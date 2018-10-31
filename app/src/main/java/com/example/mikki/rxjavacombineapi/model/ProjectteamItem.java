package com.example.mikki.rxjavacombineapi.model;

import com.google.gson.annotations.SerializedName;

public class ProjectteamItem{

	@SerializedName("teammemberuserid")
	private String teammemberuserid;

	@SerializedName("subtaskid")
	private String subtaskid;

	@SerializedName("id")
	private String id;

	@SerializedName("projectid")
	private String projectid;

	@SerializedName("taskid")
	private String taskid;

	public void setTeammemberuserid(String teammemberuserid){
		this.teammemberuserid = teammemberuserid;
	}

	public String getTeammemberuserid(){
		return teammemberuserid;
	}

	public void setSubtaskid(String subtaskid){
		this.subtaskid = subtaskid;
	}

	public String getSubtaskid(){
		return subtaskid;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setProjectid(String projectid){
		this.projectid = projectid;
	}

	public String getProjectid(){
		return projectid;
	}

	public void setTaskid(String taskid){
		this.taskid = taskid;
	}

	public String getTaskid(){
		return taskid;
	}

	@Override
 	public String toString(){
		return 
			"ProjectteamItem{" + 
			"teammemberuserid = '" + teammemberuserid + '\'' + 
			",subtaskid = '" + subtaskid + '\'' + 
			",id = '" + id + '\'' + 
			",projectid = '" + projectid + '\'' + 
			",taskid = '" + taskid + '\'' + 
			"}";
		}
}