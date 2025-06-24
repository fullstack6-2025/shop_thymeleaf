package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	// 서버에 접속을 허용할지 말지를 정의 하는 구성 정보를 저장 
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	// 모든 경로에 대해서 인증 없이 접속을 허용
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
            // H2 DB를 접속을 허용 
            .csrf((csrf) -> csrf
                    .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
            .headers((headers) -> headers
                    .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
            // 폼 로그인 처리 
            .formLogin((formLogin) -> formLogin
                    .loginPage("/user/login")
                   // .usernameParameter("username")  // 사용자 ID 필드명
                   // .passwordParameter("password")  // 비밀번호 필드명
                    .defaultSuccessUrl("/"))
            
            // 로그 아웃 처리
            .logout((logout) -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true))


        ;
        return http.build();

    }
    
    // 암호화 알고리즘 객체를 생성해서 빈등록 
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // SpringSecurity 에서 인증/허가 을 처리해주는 객체 
    // UserSecurityService.java를 사용해서 인증과 허가를 처리한다. 
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    
}
