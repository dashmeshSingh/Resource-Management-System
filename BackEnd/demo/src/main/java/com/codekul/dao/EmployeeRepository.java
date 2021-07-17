package com.codekul.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codekul.entities.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("from Employee where role =:role")
    List<Employee> findTotalEmpWithRoleEmp(String role);

//	@Query("from Project")
//	List<Project> findTotalProject();

    @Query(value="select * from Employee where role=:roles",nativeQuery=true)
    List<Employee> findProjManagers(String roles);
}
