package com.codekul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekul.dao.AdminDashboardRepository;
import com.codekul.dao.EmployeeRepository;
import com.codekul.dao.ProjectRepository;
import com.codekul.entities.Employee;
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
	
	public List<Project> getProject() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProject(int projectId) {
		
		return projectRepository.getOne(projectId);
	
	}

	@Override
	public Project addProject(Project project) {
		projectRepository.save(project);
		
		List<Employee> changeEmpStatus=employeeRepository.findByListOfEmpNames(project.getEmpAssigned());
		changeEmpStatus.forEach(emp -> {
			emp.setStatus("Active");
			
		});
		
		employeeRepository.saveAll(changeEmpStatus);
		return project;
	}

	
}
