package com.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.config.UserRole;
import com.shop.entity.SiteUser;
import com.shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService{
	//인증(ID + Pass), 허가 을 처리하는 서비스: Secutity 프레임워크에서 처리
		// 인증 (Authentication) :  ID + Password 를 확인 
		// 허가, 인가 (Authorizagion) : 인증된 사용자에게 권한을 부여함. 
	// UserDetailsService : 인터페이스를 상속해서 구현되지 않는 메소드를 구현해서 처리함.  
	
	 private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<SiteUser> _siteUser = this.userRepository.findByusername(username);

        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }

        SiteUser siteUser = _siteUser.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);

	}

	
}
