package com.codekul.service;

import java.util.List;

import com.codekul.models.DashboardResponse;
import com.codekul.models.ProjectManagerResponse;
import org.springframework.stereotype.Service;

import com.codekul.entities.Employee;


public interface EmployeeService {
	
public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	public Employee addEmployee(Employee employee);
	public DashboardResponse fetchDashboardDetails();
	//public List<Employee> findProjectManager();
	public ProjectManagerResponse findProjectManager();
}
