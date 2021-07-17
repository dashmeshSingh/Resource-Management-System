package com.codekul.service;

import com.codekul.entities.Project;

import java.util.List;

public interface ProjectService {

public List<Project> getProject();
	public Project getProject(int projectId);
	public Project addProject(Project project);
	
}
