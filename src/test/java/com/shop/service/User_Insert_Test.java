package com.shop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.SiteUser;

@SpringBootTest
public class User_Insert_Test {

	@Autowired
	private UserService userService; 
	
	
	@Test
	void userInsertTest() {
		
		String username = "admin";
		String email ="admin@aaa.com"; 
		String password = "1234"; 
		
		SiteUser siteUser = userService.create(username, email, password); 
			
		
		
	}
}
