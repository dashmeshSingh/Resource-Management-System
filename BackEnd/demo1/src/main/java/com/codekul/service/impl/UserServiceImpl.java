package com.codekul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekul.dao.UserRepository;
import com.codekul.entities.Employee;
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
	public String validateLoginDetails(String username, String password) {
		// TODO Auto-generated method stub
		User userRepo=userRepository.findByUsername(username);
		String decryptedpassword=algoutils.decrypt(userRepo.getPassword());
		String role=userRepo.getRole().name();

		if(decryptedpassword.equals(password))
		{
			
			return role;			
		}
		else
			return null;
		
					//path
	}

}
