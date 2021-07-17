package com.codekul.models;

import lombok.Data;
import lombok.Generated;

import java.util.List;

@Data
@Generated
public class DashboardResponse {

	private int totalEmp;
	private int totalProj;
	private int activeEmp;
	private int activeProj;
	private int onBenchEmp;
	private List<EmployeeResponse> employeeList;
	private List<ProjectResponse> projectList;
	private List<EmployeeStatusResponse> activemplist;
	private List<EmployeeStatusResponse>onbechemplist;
	private List<EmployeeStatusResponse>activeprojlist;
	
	public int getTotalEmp() {
		return totalEmp;
	}
	public void setTotalEmp(int totalEmp) {
		this.totalEmp = totalEmp;
	}
	public int getTotalProj() {
		return totalProj;
	}
	public void setTotalProj(int totalProj) {
		this.totalProj = totalProj;
	}
	public int getActiveEmp() {
		return activeEmp;
	}
	public void setActiveEmp(int activeEmp) {
		this.activeEmp = activeEmp;
	}
	public int getActiveProj() {
		return activeProj;
	}
	public void setActiveProj(int activeProj) {
		this.activeProj = activeProj;
	}
	public int getOnBenchEmp() {
		return onBenchEmp;
	}
	public void setOnBenchEmp(int onBenchEmp) {
		this.onBenchEmp = onBenchEmp;
	}
	public List<EmployeeResponse> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeResponse> employeeList) {
		this.employeeList = employeeList;
	}
	public List<ProjectResponse> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<ProjectResponse> projectList) {
		this.projectList = projectList;
	}
	public List<EmployeeStatusResponse> getActivemplist() {
		return activemplist;
	}
	public void setActivemplist(List<EmployeeStatusResponse> activemplist) {
		this.activemplist = activemplist;
	}
	public List<EmployeeStatusResponse> getOnbechemplist() {
		return onbechemplist;
	}
	public void setOnbechemplist(List<EmployeeStatusResponse> onbechemplist) {
		this.onbechemplist = onbechemplist;
	}
	public List<EmployeeStatusResponse> getActiveprojlist() {
		return activeprojlist;
	}
	public void setActiveprojlist(List<EmployeeStatusResponse> activeprojlist) {
		this.activeprojlist = activeprojlist;
	}
	
	
	
	
}
