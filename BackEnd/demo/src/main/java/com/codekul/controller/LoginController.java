package com.codekul.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codekul.dao.UserRepository;
//import java.util.List;
import com.codekul.entities.User;
import com.codekul.models.UserRequest;
import com.codekul.service.UserService;

@RestController
@RequestMapping(path="/hrms")
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	//testing only
	@PostMapping("/addEmp")
	public String test() {
	
		User user=new User();
		user.setUsername("gustavo.admin@test.com");
		userRepository.save(user);
		//userService.addUser();
		return "Testing successfull";
	}

	@PostMapping("/login")
	
	public String fetchHomePage(@RequestBody UserRequest userRequest )
	{
		String username = userRequest.getUsername();
		String password = userRequest.getPassword();
		String role= userRequest.getRole();
		
	return userService.fetchhomepage(username, password);
		
	}
	 
}
