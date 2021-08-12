package com.codekul.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;
import com.codekul.entities.User;


public interface UserRepository extends JpaRepository <User, Integer>  {

	User findByUsername(String username);
	//(User user);
	
}
