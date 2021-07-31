package com.codekul.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ProjectManagerResponse {
	
	private List<EmployeeResponse> projectManagerList;
	private int totalManagers;
	private List<EmployeeResponse> onBenchEmpList;
	private int totalOnBenchEmp;

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

	public List<EmployeeResponse> getOnBenchEmpList() {
		return onBenchEmpList;
	}

	public void setOnBenchEmpList(List<EmployeeResponse> onBenchEmpList) {
		this.onBenchEmpList = onBenchEmpList;
	}

	public int getTotalOnBenchEmp() {
		return totalOnBenchEmp;
	}

	public void setTotalOnBenchEmp(int totalOnBenchEmp) {
		this.totalOnBenchEmp = totalOnBenchEmp;
	}

	
}
