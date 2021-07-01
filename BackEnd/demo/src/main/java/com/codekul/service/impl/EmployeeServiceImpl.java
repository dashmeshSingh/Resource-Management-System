package com.codekul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekul.dao.EmployeeRepository;
import com.codekul.entities.Employee;
import com.codekul.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployee(int employeeId) 
	{
		
		return employeeRepository.getOne(employeeId);
	}

	public Employee addEmployee(Employee employee)
	{
		//list.add(employee);
		employeeRepository.save(employee);
		return employee;
	}
	
}
