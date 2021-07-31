package com.codekul.service;

import java.util.List;

import com.codekul.entities.Employee;
import com.codekul.models.DashboardResponse;
import com.codekul.models.EmployeeRequest;
import com.codekul.models.ProjectManagerResponse;


public interface EmployeeService {
	
public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	public Employee addEmployee(Employee employee);
	public DashboardResponse fetchDashboardDetails(String username, String role);
	//public List<Employee> findProjectManager();
	public ProjectManagerResponse findProjectManager();
	public ProjectManagerResponse findOnBenchEmployee(String username);
	public ProjectManagerResponse findProjectManageName(String username);
}
