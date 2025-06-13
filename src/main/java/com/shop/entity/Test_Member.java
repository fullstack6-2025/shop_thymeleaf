package com.shop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Test_Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ; 
	private String name; 
	private String phone; 
	private int age;
	private LocalDateTime createDate; 
	
	// 1. for 문을 사용해서 레코드 100개 추가 	: insert
	// 2. 레코드 전체 출력 (콘솔에)          : select 
	// 3. 99번 레코드를 콘솔에 출력 			: select
	// 4. 99번 레코드를 수정				: update
	// 5. 99번 레코드를 삭제 				: delete
	
}
