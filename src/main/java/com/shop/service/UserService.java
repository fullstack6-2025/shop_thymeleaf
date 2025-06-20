package com.shop.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.entity.SiteUser;
import com.shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository; 
	private final PasswordEncoder passwordEncoder;
	
	// 회원 가입 메소드 
    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();

        user.setUsername(username);
        user.setEmail(email);

        // 여기서 암호화 객체를 생성하면 안됨 : 문제 생성시 복구가 어렵울 수 있다. 
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));

        this.userRepository.save(user);
        return user;

    }


}
