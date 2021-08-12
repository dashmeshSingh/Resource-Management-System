package com.codekul.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekul.dao.AdminDashboardRepository;
import com.codekul.dao.EmployeeRepository;
import com.codekul.dao.InvoiceRepository;
import com.codekul.dao.ProjectRepository;
import com.codekul.entities.Invoice;
import com.codekul.models.InvoiceRequest;
import com.codekul.models.InvoiceResponse;
import com.codekul.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminDashboardRepository adminDashboardRepo;

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public InvoiceResponse getInvoiceDetails(String projectName) {
		// TODO Auto-generated method stub
		
		InvoiceResponse invoiceResponse= new InvoiceResponse();
		InvoiceRequest invoiceRequest=new InvoiceRequest();
		
		List<Invoice> invoiceList= invoiceRepository.findInvoiceDetailsByProjId(projectName);
		List<InvoiceResponse> invoiceDetails=new ArrayList<>();
		
		if(invoiceList!=null)
		{
			invoiceRequest.setTotalEmpAssigned(invoiceList.size());
			invoiceList.forEach(invoice -> {
				invoiceResponse.setProjectName(invoice.getProjectName());
				invoiceResponse.setProjId(invoice.getProjId());
				invoiceResponse.setBillingDate(invoice.getBillingDate());
				invoiceResponse.setInvoiceId(invoice.getInvoiceId());
				invoiceResponse.setClientName(invoice.getClientName());
				invoiceResponse.setClientAddress(invoice.getClientAddress());
				invoiceResponse.setClientContact(invoice.getClientContact());
				invoiceResponse.setGSTno(invoice.getGSTno());
				invoiceResponse.setPaymentdDay(invoice.getPaymentdDay());
				invoiceResponse.setEmpAssigned(invoice.getEmpAssigned());
				invoiceResponse.setDuration(invoice.getDuration());
				invoiceResponse.setTotalEmpAssigned(invoice.getEmpAssigned().size());
				invoiceResponse.setClientContactPerson(invoice.getClientContactPerson());
				
				invoiceDetails.add(invoiceResponse);
				
			});
			
			invoiceRequest.setInvoiceDetailsList(invoiceDetails);
		}
		return invoiceResponse;
	}

}
