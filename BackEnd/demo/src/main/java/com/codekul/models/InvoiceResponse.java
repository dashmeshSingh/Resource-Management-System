package com.codekul.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class InvoiceResponse {


	private int invoiceId;
	private String GSTno;
	private LocalDate billingDate;
	private int projId;
	private String projectName;
	private List<String> empAssigned= new ArrayList<String>();
	private String clientAddress;
	private String clientContact;
	private int paymentdDay;
	private String clientName;
	private int duration;
	
	
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getGSTno() {
		return GSTno;
	}
	public void setGSTno(String gSTno) {
		GSTno = gSTno;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	public List<String> getEmpAssigned() {
		return empAssigned;
	}
	public void setEmpAssigned(List<String> empAssigned) {
		this.empAssigned = empAssigned;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientContact() {
		return clientContact;
	}
	public void setClientContact(String clientContact) {
		this.clientContact = clientContact;
	}
	public int getPaymentdDay() {
		return paymentdDay;
	}
	public void setPaymentdDay(int paymentdDay) {
		this.paymentdDay = paymentdDay;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}
