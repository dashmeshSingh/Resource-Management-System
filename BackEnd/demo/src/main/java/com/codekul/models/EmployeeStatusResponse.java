package com.codekul.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class EmployeeStatusResponse {

	private int empid;
	private String empname;
	private String projectname;
	private String empstatus;
	private String projectstatus;
	private String Manager;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getEmpstatus() {
		return empstatus;
	}
	public void setEmpstatus(String empstatus) {
		this.empstatus = empstatus;
	}
	public String getProjectstatus() {
		return projectstatus;
	}
	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}
	public String getManager() {
		return Manager;
	}
	public void setManager(String manager) {
		Manager = manager;
	}
	
	
	
}
