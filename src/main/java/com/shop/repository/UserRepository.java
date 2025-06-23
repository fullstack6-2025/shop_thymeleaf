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
	
	// findById() : 필드만 값을 넣어서 리턴되는 메소드가 만들어 져 있고 그 외의 필드는 생성해 줘야 한다. 
	// select * from Site_User where username=?
	Optional<SiteUser> findByusername(String username);
	 
}
