package com.codekul.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.codekul.dao.AdminDashboardRepository;
import com.codekul.dao.ProjectRepository;
import com.codekul.entities.AdminDashboard;
import com.codekul.entities.Project;
import com.codekul.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekul.dao.EmployeeRepository;
import com.codekul.entities.Employee;
import com.codekul.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminDashboardRepository adminDashboardRepo;

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployee(int employeeId) 
	{
		
		return employeeRepository.getOne(employeeId);
	}

	public Employee addEmployee(Employee employee)
	{
		//list.add(employee);
		employeeRepository.save(employee);
		return employee;
	}
	@Override
	public DashboardResponse fetchDashboardDetails() {
		// TODO Auto-generated method stub
		DashboardResponse dashboardRepo= new DashboardResponse();
		List<AdminDashboard> adminDashboardList=adminDashboardRepo.findAll();
		List<AdminDashboard> activeEmpList=adminDashboardList.stream().filter(dashboard -> dashboard.getEmpstatus().equalsIgnoreCase("Active")).collect(Collectors.toList());
		List<AdminDashboard> onBenchEmpList=adminDashboardList.stream().filter(dashboard -> dashboard.getEmpstatus().equalsIgnoreCase("On Bench")).collect(Collectors.toList());

		List<EmployeeResponse> employeeResponseList=new ArrayList<>();
		List<Employee> employeeList=employeeRepository.findTotalEmpWithRoleEmp("Employee");

		if(employeeList!=null)
		{
			dashboardRepo.setTotalEmp(employeeList.size());
			employeeList.forEach(employee ->{
				EmployeeResponse employeeResponse= new EmployeeResponse();
				employeeResponse.setEmpName(employee.getEmpname());
				employeeResponse.setReportingTo(employee.getReportingto());
				employeeResponseList.add(employeeResponse);
			});

			dashboardRepo.setEmployeeList(employeeResponseList);
		}

		List<ProjectResponse> projectResponseList=new ArrayList<>();
		List<Project> projectList=projectRepository.findTotalProject();

		if(projectList!=null)
		{
			dashboardRepo.setTotalProj(projectList.size());
			projectList.forEach(project ->{
				ProjectResponse projectResponse= new ProjectResponse();
				projectResponse.setProjName(project.getProjName());
				projectResponse.setProjDesc(project.getProjDesc());
				projectResponse.setClient(project.getClient());
				projectResponse.setDuration(project.getDuration());
				projectResponse.setEmpAssigned(project.getEmpAssigned());
				projectResponse.setProjManager(project.getProjManager());
				projectResponseList.add(projectResponse);
			});

			dashboardRepo.setProjectList(projectResponseList);
		}

		List<EmployeeStatusResponse> employeeStatusResponseList=new ArrayList<>();


		if(activeEmpList!=null)
		{
			dashboardRepo.setActiveEmp(activeEmpList.size());
			activeEmpList.forEach(admindashboard ->
			{
				EmployeeStatusResponse projStatusResponse=new EmployeeStatusResponse();
				projStatusResponse.setEmpid(admindashboard.getEmpid());
				projStatusResponse.setEmpname(admindashboard.getEmpname());
				projStatusResponse.setProjectname(admindashboard.getProjectname());
				projStatusResponse.setManager(admindashboard.getManager());
				employeeStatusResponseList.add(projStatusResponse);
			});

			dashboardRepo.setActivemplist(employeeStatusResponseList);

		}

		List<EmployeeStatusResponse> empStatusResponseList=new ArrayList<>();


		if(onBenchEmpList!=null)
		{
			dashboardRepo.setOnBenchEmp(onBenchEmpList.size());
			onBenchEmpList.forEach(adminDashboard ->
			{
				EmployeeStatusResponse projStatResponse=new EmployeeStatusResponse();
				projStatResponse.setEmpid(adminDashboard.getEmpid());
				projStatResponse.setEmpname(adminDashboard.getEmpname());
				projStatResponse.setManager(adminDashboard.getManager());
				empStatusResponseList.add(projStatResponse);

			});

			dashboardRepo.setOnbechemplist(empStatusResponseList);
		}

		List<EmployeeStatusResponse>empStatResponseList= new ArrayList<>();
		List<AdminDashboard> projStatList=adminDashboardRepo.findProjectByStatus("Active");

		if(projStatList!=null)
		{
			dashboardRepo.setActiveProj(projStatList.size());
			projStatList.forEach(admindashboards ->
			{
				EmployeeStatusResponse projStat=new EmployeeStatusResponse();
				projStat.setProjectname(admindashboards.getProjectname());
				projStat.setEmpname(admindashboards.getEmpname());
				projStat.setManager(admindashboards.getManager());
				projStat.setEmpid(admindashboards.getEmpid());

				empStatResponseList.add(projStat);
			});

			dashboardRepo.setActiveprojlist(empStatResponseList);
		}



		return dashboardRepo;
	}

	@Override
	public ProjectManagerResponse findProjectManager() {
		// TODO Auto-generated method stub
		ProjectManagerResponse projManagerRes= new ProjectManagerResponse();

		List<EmployeeResponse> employeeResponseList=new ArrayList<>();
		List<Employee> employeeList=employeeRepository.findTotalEmpWithRoleEmp("projectManager");

		if(employeeList!=null)
		{
			projManagerRes.setTotalManagers(employeeList.size());
			employeeList.forEach(employee ->{
				EmployeeResponse employeeResponse= new EmployeeResponse();
				employeeResponse.setEmpName(employee.getEmpname());
				employeeResponseList.add(employeeResponse);
			});

			projManagerRes.setProjectManagerList(employeeResponseList);
		}

		return projManagerRes;
	}
	
}
