package com.example.mikki.rxjavacombineapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ProjectTeam{

	@SerializedName("projectteam")
	private List<ProjectteamItem> projectteam;

	public void setProjectteam(List<ProjectteamItem> projectteam){
		this.projectteam = projectteam;
	}

	public List<ProjectteamItem> getProjectteam(){
		return projectteam;
	}

	@Override
 	public String toString(){
		return 
			"ProjectTeam{" + 
			"projectteam = '" + projectteam + '\'' + 
			"}";
		}
}