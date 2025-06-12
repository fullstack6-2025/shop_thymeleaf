package com.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestEntity {
	
	// 테이블 에서 반드시 primary key 컬럼이 존재 해야 한다. 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx ; 
	
	private String name; 
	
	private String addr; 
	
	private double weight; 
	
	private int age; 
	
	

}
