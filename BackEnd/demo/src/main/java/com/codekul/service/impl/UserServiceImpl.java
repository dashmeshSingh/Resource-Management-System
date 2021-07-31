package com.codekul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekul.dao.UserRepository;
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
	public String validateLoginDetails(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		User userRepo=userRepository.findByUsername(username);
		String decryptedpassword=algoutils.decrypt(userRepo.getPassword());
		String role=userRepo.getRole().name();

		if(decryptedpassword.equals(password))
		{
			
			return role;			
		}
		else
			 throw new Exception("Login Credentials do not match. Try Again");
		
					//path
	}

}
