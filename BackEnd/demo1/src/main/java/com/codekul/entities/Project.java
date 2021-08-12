package com.codekul.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Project")
public class Project {

	@Id
	@Column(name="projectId")
	private int projId;
	
	@Column(name="projectName")
	private String projName;
	
	@Column(name="projectDescription")
	private String projDesc;
	
	@Column(name="projectDuration")
	private int duration;
	
	@Column(name="StartDate")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date startDate;
	
	@Column(name="clientName")
	private String client;
	
	@Column(name="Payment")
	private int payment;
	
	@Column(name="EmpAssigned")
	@ElementCollection
	private List<String> empAssigned=new ArrayList<String>();
	
	@Column(name="EmpEmail")
	@ElementCollection
	private List<String> empEmail= new ArrayList<String>();
	
	@Column(name="ManagedBy")
	private String projManager;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<String> getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(List<String> empEmail) {
		this.empEmail = empEmail;
	}
	
	
}
