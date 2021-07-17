package com.codekul.controller;

import com.codekul.entities.Project;
import com.codekul.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public Project addProject(@RequestBody Project project)
	{
		return this.projectService.addProject(project);
	}
	


}
