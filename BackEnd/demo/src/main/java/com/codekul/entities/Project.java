package com.codekul.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="projectId")
	private int projId;
	
	@Column(name="projectName")
	private String projName;
	
	@Column(name="projectDescription")
	private String projDesc;
	
	@Column(name="StartDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
	@Column(name="clientName")
	private String client;
	
	@Column(name="PaymentPerDay")
	private int paymentPerDay;
	
	@Column(name="EmpAssigned")
	@ElementCollection
	private List<String> empAssigned=new ArrayList<String>();
	
	@Column(name="EndDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	
	@Column(name="ContactPerson")
	private String contactPerson;
	
	@Column(name="ContactPersonContact")
	private String contactPersonContact;
	
	@Column(name="ClientAddress")
	private String clientAddress;
	
	@Column(name="Duration")
	private int duration;

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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getPaymentPerDay() {
		return paymentPerDay;
	}

	public void setPaymentPerDay(int paymentPerDay) {
		this.paymentPerDay = paymentPerDay;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPersonContact() {
		return contactPersonContact;
	}

	public void setContactPersonContact(String contactPersonContact) {
		this.contactPersonContact = contactPersonContact;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	
}
