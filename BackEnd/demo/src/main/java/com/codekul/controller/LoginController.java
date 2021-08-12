package com.codekul.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codekul.dao.UserRepository;
//import java.util.List;
import com.codekul.entities.User;
import com.codekul.models.UserRequest;
import com.codekul.service.EmployeeService;
import com.codekul.service.UserService;

@RestController
@RequestMapping(path="/hrms")
@CrossOrigin(origins = "*" )
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;


	@PostMapping("/login")
	
	public String validateLoginDetails(@RequestBody UserRequest userRequest ) throws Exception
	{
		String username = userRequest.getUsername();
		String password = userRequest.getPassword();
		System.out.println(username + " "+ password);
		String role=userService.validateLoginDetails(username, password);
		return role;
		
	}
	
}
