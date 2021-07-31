package com.codekul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codekul.models.InvoiceResponse;
import com.codekul.service.InvoiceService;

@RestController
@RequestMapping(path="/hrms")
@CrossOrigin(origins = "*" )
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	@GetMapping("/invoice")
	public InvoiceResponse getInvoiceDetails(@RequestParam String projectName)
	{
		return this.invoiceService.getInvoiceDetails(projectName);
	}
}
