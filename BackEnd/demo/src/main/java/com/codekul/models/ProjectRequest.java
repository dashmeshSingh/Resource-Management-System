package com.codekul.models;

import java.time.LocalDate;
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
	private String client;
	private List<String> empAssigned= new ArrayList<String>();
	private String projManager;
	private LocalDate startDate;
	private int paymentPerDay;
	private LocalDate endDate;
	private String contactPerson;
	private String contactPersonContact;
	private String clientAddress;

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
	
	
	
}
