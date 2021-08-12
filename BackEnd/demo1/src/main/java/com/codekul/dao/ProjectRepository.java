package com.codekul.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codekul.entities.Employee;
import com.codekul.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
	
	@Query("from Project")
	List<Project> findTotalProject();
	
	@Query(value="Select * from project where project_name=:projectname",nativeQuery=true)
	List<Project> findProjectDetailsByProjName(String projectname);
}
