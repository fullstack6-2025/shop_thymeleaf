package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.SiteUser;

@SpringBootTest
public class UserRepository_Test {
	
	@Autowired
	UserRepository userRepository; 
	
	@Test
	void userRepositoryTest() {
		// Optional<SiteUser> findByusername(String username);
		
		Optional<SiteUser> _siteUeser =
				userRepository.findByusername("admin"); 
		
		SiteUser siteUser = new SiteUser(); 
		
		if ( _siteUeser.isPresent()) {
			siteUser = _siteUeser.get(); 
		}
		
		System.out.println(siteUser.getId());
		System.out.println(siteUser.getEmail());
		System.out.println(siteUser.getUsername());
		System.out.println(siteUser.getPassword());
		
		
		
	}

}
