package com.codekul.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codekul.entities.Employee;


public interface EmployeeService {
	
public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	public Employee addEmployee(Employee employee);
}
