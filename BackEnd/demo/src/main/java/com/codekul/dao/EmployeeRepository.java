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
	
	@Query("from Employee where role in(:roles)")
	List<Employee> findTotalEmpWithRoleEmp(@Param("roles")List<String> roles);
	
	@Query(value="select * from Employee where role=:role1 or role=:role2",nativeQuery=true)
	List<Employee> findTotalEmpCount(String role1,String role2);
	
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
	
	@Query(value="select * from employee where empname in(:names) LIMIT 1",nativeQuery=true)
	List<Employee> findByListOfEmpNamesLimitOne(@Param("names")List<String> names);
	

	@Query(value="select * from Employee where email=:username",nativeQuery=true)
	List<Employee> findProjManagerName(String username);
	
	@Query(value="select * from Employee where empname=:empname",nativeQuery=true)
	Optional<Employee> findProjManagerId(String empname);
}
