package com.codekul.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codekul.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("from Employee where role =:role")
	List<Employee> findTotalEmpWithRoleEmp(String role);
	
	@Query(value="select * from Employee",nativeQuery=true)
	List<Employee> findAll();
	
//	@Query("from Project")
//	List<Project> findTotalProject();
	
	@Query(value="select * from Employee where role=:roles",nativeQuery=true)
	List<Employee> findProjManagers(String roles);
	
	@Query(value="select * from Employee where email=:username and status=:status",nativeQuery=true)
	Optional<Employee> findByUsernameAndStatus(String username, String status);
	
	
	@Query(value="select * from Employee where status=:status",nativeQuery=true)
	List<Employee> findEmployeeByStatus(String status);
	
//	@Modifying
//	@Transactional 
	@Query(value="select * from employee where empname in(:names)",nativeQuery=true)
	List<Employee> findByListOfEmpNames(@Param("names")List<String> names);
	
}
