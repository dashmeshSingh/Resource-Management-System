package com.codekul.service;

import java.util.List;

import com.codekul.entities.Employee;
import com.codekul.entities.Project;

import com.codekul.models.DashboardResponse;

public interface ProjectService {

public List<Project> getProject();
	public Project getProject(int projectId);
	public Project addProject(Project project);
	
}
