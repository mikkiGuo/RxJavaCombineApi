package com.example.mikki.rxjavacombineapi.networkhelper;

import com.example.mikki.rxjavacombineapi.model.ProjectTeam;
import com.example.mikki.rxjavacombineapi.model.ProjectteamItem;
import com.example.mikki.rxjavacombineapi.model.TeamMemberDetail;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    /**
     * Team member ids for Project
     * http://rjtmobile.com/aamir/pms/android-app/
     * pms_project_team.php?
     * project_id=29
     */
    @GET("pms_project_team.php")
    Observable<ProjectTeam> getProjectTeam(@Query("project_id") int id);

    /**
     * Member details by id
     * http://rjtmobile.com/aamir/pms/android-app/
     * pms_team_member_deatil.php?
     * memberuserid=15
     */
    @GET("pms_team_member_deatil.php")
    Observable<TeamMemberDetail> getTeamMemberDetailById(
            @Query("memberuserid") int memberuserid);
}
