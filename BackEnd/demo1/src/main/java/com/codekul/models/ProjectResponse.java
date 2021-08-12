package com.codekul.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class ProjectResponse {

	
	private String projName;
	private String projDesc;
	private String client;
	private int duration;
	private List<String> empAssigned=new ArrayList<String>();
	private String projManager;
	
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getProjDesc() {
		return projDesc;
	}
	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public List<String> getEmpAssigned() {
		return empAssigned;
	}
	public void setEmpAssigned(List<String> empAssigned) {
		this.empAssigned = empAssigned;
	}
	public String getProjManager() {
		return projManager;
	}
	public void setProjManager(String projManager) {
		this.projManager = projManager;
	}
	
	
	
}
