package com.shop.config;

import lombok.Getter;

@Getter
public enum UserRole {
	// enum에서 정해진 값만 필드에 넣을 수 있다. 
		// 요일 : 월, 화, 수, 목, 금, 토, 일  
		// 사용자의 권한 : 일반사용자, 관리자, 중간관리자 
		// 카테고리 처리 : 의류, 신발, 자동차...
	
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;


}
