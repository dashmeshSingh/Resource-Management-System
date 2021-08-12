package com.codekul.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.codekul.dao.AdminDashboardRepository;
import com.codekul.dao.EmployeeRepository;
import com.codekul.dao.InvoiceRepository;
import com.codekul.dao.ProjectRepository;
import com.codekul.entities.AdminDashboard;
import com.codekul.entities.Employee;
import com.codekul.entities.Invoice;
import com.codekul.entities.Project;
import com.codekul.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private AdminDashboardRepository adminDashboardRepo;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public List<Project> getProject() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProject(int projectId) {
		
		return projectRepository.getOne(projectId);
	
	}

	@Override
	public Project addProject(Project project) throws Exception {
		
		List<AdminDashboard> adminDashboardList=new ArrayList<>();
		List<Invoice> invoiceList= new ArrayList<>();
		List<Project> empAlreadyAssigned=projectRepository.findProjectByEmpAssigned(project.getEmpAssigned());
		
		if(CollectionUtils.isEmpty(empAlreadyAssigned))
		{
			
			Project projectDetails=projectRepository.save(project);
			
			List<Employee>employeeInvoice=employeeRepository.findByListOfEmpNamesLimitOne(project.getEmpAssigned());
			
			List<Employee> changeEmpStatus=employeeRepository.findByListOfEmpNames(project.getEmpAssigned());
			changeEmpStatus.forEach(emp -> {
				emp.setStatus("Active");
				
			});
			
			Optional<Employee> manager=employeeRepository.findProjManagerId(project.getProjManager());
			changeEmpStatus.forEach(emp -> {
				
				AdminDashboard adminDashboardData= new AdminDashboard();
				
				adminDashboardData.setEmpid(emp.getEmpid());
				adminDashboardData.setEmpname(emp.getEmpname());
				adminDashboardData.setEmpstatus(emp.getStatus());
				adminDashboardData.setProjectname(project.getProjName());
				adminDashboardData.setProjectstatus("Active");
				adminDashboardData.setManager(project.getProjManager());
				adminDashboardData.setManagerId(manager.get().getEmpid());
				
				adminDashboardList.add(adminDashboardData);
				
			});
					
			adminDashboardRepo.saveAll(adminDashboardList);
			
			LocalDate startDate= projectDetails.getStartDate();
			LocalDate endDate=projectDetails.getEndDate();
			Period periodDiff = Period.between(startDate, endDate);
			int duration=periodDiff.getDays();
			
			employeeInvoice.forEach(emp -> {
				
				Invoice invoiceData= new Invoice();

				invoiceData.setProjId(projectDetails.getProjId());
				invoiceData.setProjectName(project.getProjName());
				invoiceData.setClientName(project.getClient());
				invoiceData.setBillingDate(project.getEndDate());
				invoiceData.setClientContact(project.getContactPerson());
				invoiceData.setEmpAssigned(project.getEmpAssigned());
				invoiceData.setPaymentdDay(project.getPaymentPerDay());
				invoiceData.setInvoiceId(project.getPaymentPerDay());
				invoiceData.setClientAddress(project.getClientAddress());
				invoiceData.setDuration(project.getDuration());
				invoiceData.setClientContactPerson(project.getContactPersonContact());
				
				invoiceList.add(invoiceData);

			});
			
			invoiceRepository.saveAll(invoiceList);
			
			employeeRepository.saveAll(changeEmpStatus);
			
			
			return project;
		}

		else
		{
			throw new Exception("List of Employees are already assigned to another project");
		}
		
		}
		
	
}
