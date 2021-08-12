package com.codekul.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="invoiceId")
	private int invoiceId;
	
	@Column(name="GSTno")
	private String GSTno;
	
	@Column(name="billingDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate billingDate;
	
	
	@Column(name="projectId")
	private int projId;
	
	@Column(name="projectName")
	private String projectName;
	
	
	@Column(name="empAssigned")
	@ElementCollection
	  @CollectionTable(
	        name="invoice_emp_assigned",
	        joinColumns=@JoinColumn(name="invoiceId")
	        
	  )
	private List<String> empAssigned=new ArrayList<String>();
	
	@Column(name="clientName")
	private String clientName;
	
	@Column(name="ClientAddress")
	private String clientAddress;
	
	@Column(name="clientContact")
	private String clientContact;
	
	@Column(name="PaymentPerDay")
	private int paymentdDay;

	@Column(name="Duration")
	private int duration;
	
	@Column(name="ClientContactPerson")
	private String clientContactPerson;
	
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

	public String getClientContactPerson() {
		return clientContactPerson;
	}

	public void setClientContactPerson(String clientContactPerson) {
		this.clientContactPerson = clientContactPerson;
	}
	
	
	
	
}
