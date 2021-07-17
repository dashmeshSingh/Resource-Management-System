package com.codekul.models;

import java.util.List;

public class ProjectManagerResponse {
	
	private List<EmployeeResponse> projectManagerList;
	private int totalManagers;

	public List<EmployeeResponse> getProjectManagerList() {
		return projectManagerList;
	}

	public void setProjectManagerList(List<EmployeeResponse> projectManagerList) {
		this.projectManagerList = projectManagerList;
	}

	public int getTotalManagers() {
		return totalManagers;
	}

	public void setTotalManagers(int totalManagers) {
		this.totalManagers = totalManagers;
	}

	
}
