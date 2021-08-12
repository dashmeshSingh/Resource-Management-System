package com.codekul.service;

import java.util.List;

import com.codekul.entities.Employee;
import com.codekul.entities.User;

public interface UserService  {
	
	//public User adduser(User user);
	public String validateLoginDetails(String username, String password);

	
}
