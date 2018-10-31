package com.example.mikki.rxjavacombineapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mikki.rxjavacombineapi.model.ProjectTeam;
import com.example.mikki.rxjavacombineapi.model.ProjectteamItem;
import com.example.mikki.rxjavacombineapi.networkhelper.ApiService;
import com.example.mikki.rxjavacombineapi.networkhelper.RetrofitInstance;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    final private static String TAG = "MyTag";
    ApiService apiService;
    Button btnGetDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetDetail = findViewById(R.id.btn_getdetail);
        apiService = RetrofitInstance.getRetrofit().create(ApiService.class);


        btnGetDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTeamMemberFromProject();
            }
        });

//        Observable<ProjectTeam> projectTeamObservable = apiService.getProjectTeam(29);
//
//        projectTeamObservable
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<ProjectTeam>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe: " + d.toString());
//                    }
//
//                    @Override
//                    public void onNext(ProjectTeam projectTeam) {
//                        Log.d(TAG, "onNext: " + projectTeam.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError: "+ e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: ");
//                    }
//                });
    }

    public void getTeamMemberFromProject(){
        apiService.getProjectTeam(29)
                .flatMap(
                        s->{
                            Log.d(TAG, s.getProjectteam().toString());
                            return Observable.fromIterable(s.getProjectteam());
                        }
                ).flatMap(s->{
            Log.d(TAG, "id: "+s.getId()+" usrid: "+s.getTeammemberuserid());

            return apiService.getTeamMemberDetailById(
                    Integer.parseInt(s.getTeammemberuserid())).flatMap(
                    member->{
                        Log.d(TAG, "onCreate: " + member.toString());
                        return Observable.just(member);
                    });
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
