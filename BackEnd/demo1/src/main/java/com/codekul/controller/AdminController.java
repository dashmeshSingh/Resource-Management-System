package com.codekul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codekul.entities.Employee;
import com.codekul.models.DashboardResponse;
import com.codekul.models.ProjectManagerResponse;
import com.codekul.service.EmployeeService;

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
	public DashboardResponse fetchDashboardDetails(@RequestParam String username, @RequestParam String role)
	{
		return this.employeeService.fetchDashboardDetails(username,role);
	}
	
	@GetMapping("/projManager")
	public ProjectManagerResponse findProjectManager()
	{
		return this.employeeService.findProjectManager();
	}
	
	@GetMapping("/onBenchEmp")
	public ProjectManagerResponse findOnBenchEmployee(@RequestParam String username)
	{
		return this.employeeService.findOnBenchEmployee(username);
	}
	

	
}


