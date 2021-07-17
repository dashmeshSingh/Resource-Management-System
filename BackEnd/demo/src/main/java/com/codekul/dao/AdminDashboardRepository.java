package com.codekul.dao;

import com.codekul.entities.AdminDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDashboardRepository extends JpaRepository <AdminDashboard,String>{
	
	//List<AdminDashboard> findDistinctByEmpId();
	
	@Query(value="select * from AdminDashboard",nativeQuery=true)
	List<AdminDashboard> findAll();
	

	@Query("from AdminDashboard where projectstatus =:projectstatus")
	List<AdminDashboard> findProjectByStatus(String projectstatus);

//	@Query(value="select * from AdminDashboard where manager=:manager and status=:status",nativeQuery=true)
//	List<AdminDashboard> findManagerAndStatus(String username, String status);
//	
}
