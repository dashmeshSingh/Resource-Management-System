package com.codekul.service.impl;

import com.codekul.dao.AdminDashboardRepository;
import com.codekul.dao.ProjectRepository;
import com.codekul.entities.Project;
import com.codekul.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private AdminDashboardRepository adminDashboardRepo;
	
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
		return project;
	}

	
}
