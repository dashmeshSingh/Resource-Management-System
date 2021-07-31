package com.codekul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codekul.entities.Employee;
import com.codekul.entities.Project;
import com.codekul.models.DashboardResponse;
import com.codekul.service.ProjectService;

@RestController
@RequestMapping(path="/hrms")
@CrossOrigin(origins = "*" )
public class ProjectController {

	@Autowired 
	private ProjectService projectService;
	
	@GetMapping("/getproject")
	public List<Project> getProject()
	{
		return this.projectService.getProject();
		
	}
	
	//Check the employee id
	@GetMapping("/getproject/{projectId}")
	public Project getProject(@PathVariable String projectId)
	{
		return this.projectService.getProject(Integer.parseInt(projectId));
	}
	
	//add the employee
	@PostMapping(path="/addproject",consumes="application/json")
	public Project addProject(@RequestBody Project project) throws Exception
	{
		return this.projectService.addProject(project);
	}
	
	
}
