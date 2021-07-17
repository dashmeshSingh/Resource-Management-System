package com.codekul.controller;

import com.codekul.entities.Employee;
import com.codekul.models.DashboardResponse;
import com.codekul.models.ProjectManagerResponse;
import com.codekul.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/hrms")
@CrossOrigin(origins = "*" )
public class AdminController {
	
	@Autowired 
	private EmployeeService employeeService;
	
	@GetMapping("/getemployee")
	public List<Employee> getEmployees()
	{
		return this.employeeService.getEmployees();
		
	}
	
	//Check the employee id
	@GetMapping("/getemployee/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId)
	{
		return this.employeeService.getEmployee(Integer.parseInt(employeeId));
	}
	
	//add the employee
	@PostMapping(path="/addemployee",consumes="application/json")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return this.employeeService.addEmployee(employee);
	}

	@GetMapping("/dashboardDetails")
	public DashboardResponse fetchDashboardDetails()
	{
		return this.employeeService.fetchDashboardDetails();
	}
	
	@GetMapping("/projManager")
	public ProjectManagerResponse findProjectManager()
	{
		return this.employeeService.findProjectManager();
	}
	

	
}


