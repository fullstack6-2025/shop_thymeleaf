package com.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 예외 처리 : 프로그램이 멈추지 않도록 처리 
	// 런타임 오류 : 프로그램이 실행시 멈춤(오류가 발생됨)
	// 컴파일 오류 : 코드를 작성시 오류를 방생시킴. 

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}

}
