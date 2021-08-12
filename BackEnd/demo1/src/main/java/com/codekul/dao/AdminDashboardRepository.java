package com.codekul.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codekul.entities.AdminDashboard;

@Repository
public interface AdminDashboardRepository extends JpaRepository <AdminDashboard,String>{
	
	//List<AdminDashboard> findDistinctByEmpId();
	
	@Query(value="select * from AdminDashboard",nativeQuery=true)
	List<AdminDashboard> findAll();
	

	@Query("from AdminDashboard where projectstatus =:projectstatus")
	List<AdminDashboard> findProjectByStatus(String projectstatus);

	@Query(value="select * from Admindashboard where manager_id =:managerId group by empname",nativeQuery=true)
	List<AdminDashboard> findByEmployeeId(int managerId);
	
	@Query(value="select distinct projectname from admindashboard where manager_id=:managerId",nativeQuery=true)
	List<String> findDistinctProjectNameByManagerId(int managerId);
	
}
