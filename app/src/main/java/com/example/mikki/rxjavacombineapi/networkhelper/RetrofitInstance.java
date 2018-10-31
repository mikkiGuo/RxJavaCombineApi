package com.example.mikki.rxjavacombineapi.networkhelper;

import com.example.mikki.rxjavacombineapi.model.ProjectTeam;
import com.example.mikki.rxjavacombineapi.model.TeamMemberDetail;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitInstance {
    private final static String BASE_URL = "http://rjtmobile.com/aamir/pms/android-app/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

}


