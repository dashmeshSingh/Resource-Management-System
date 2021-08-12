package com.codekul.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class ProjectRequest {

	private int projId;
	private String projName;
	private String projDesc;
	private int duration;
	private String client;
	private int payment;
	private List<String> empAssigned= new ArrayList<String>();
	private String projManager;
	private List<String> empEmail= new ArrayList<String>();
	private Date startDate;
	
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
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
	public List<String> getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(List<String> empEmail) {
		this.empEmail = empEmail;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
}
