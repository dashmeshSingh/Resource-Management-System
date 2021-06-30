package com.codekul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekul.dao.UserRepository;
import com.codekul.entities.Role;
import com.codekul.entities.User;
import com.codekul.service.UserService;
import com.codekul.utils.EncryptDecryptUtils;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EncryptDecryptUtils algoutils;

	@Override
	public String fetchhomepage(String username, String password) {
		// TODO Auto-generated method stub
		User userRepo=userRepository.findByUsername(username);
		String decryptedpassword=algoutils.decrypt(userRepo.getPassword());
		String role=userRepo.getRole().name();

		if(decryptedpassword.equals(password))
		{
			if(role.equals(Role.Admin.name()))
				return "admindashboard"; //admin homepage path
			
			else if (role.equals(Role.projectManager.name()))
			
				return "projectManager";  //project homepage path 
		
			else if(role.equals(Role.financeUser.name()))
				return "financeUser";  //emp homepage path
			
			else
				return "Role does not match-Login page";
		}
		
		else
			return "Password does not match-Login  page";		//path
	}
	
	

}
