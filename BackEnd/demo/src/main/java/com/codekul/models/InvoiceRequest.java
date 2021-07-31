package com.codekul.models;

import java.util.List;

import lombok.Data;
import lombok.Generated;


@Data
@Generated
public class InvoiceRequest {
 
	
	private int totalEmpAssigned;
	private List<InvoiceResponse> invoiceDetailsList;
	
	
	public int getTotalEmpAssigned() {
		return totalEmpAssigned;
	}
	public void setTotalEmpAssigned(int totalEmpAssigned) {
		this.totalEmpAssigned = totalEmpAssigned;
	}
	public List<InvoiceResponse> getInvoiceDetailsList() {
		return invoiceDetailsList;
	}
	public void setInvoiceDetailsList(List<InvoiceResponse> invoiceDetailsList) {
		this.invoiceDetailsList = invoiceDetailsList;
	}
	
	
}
