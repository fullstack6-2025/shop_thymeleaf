package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.SiteUser;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
	// 상속되어 내려오는 메소드 
		// findAll()
		// findById()
		// save()
		// delete()
	
	// select * from Site_User where username=?
	Optional<SiteUser> findByusername(String username);
	 
}
