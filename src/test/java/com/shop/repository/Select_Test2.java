package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;

@SpringBootTest
public class Select_Test2 {
	
	// Answer 테이블의 id : 1  의 값을 가지고 옴 
	
	@Autowired
	AnswerRepository answerRepository; 
	
	@Test
	void selectTest2() {
		
		Answer a = new Answer(); 
		
		Optional<Answer> oa = 
				answerRepository.findById(1); 
		
		// oa 의 내부의 존재하는  Answer 객체를 끄집어 낸다. 
		if (oa.isPresent()) {
			a = oa.get(); 
		}
		
		System.out.println(a.getId());
		System.out.println(a.getContent());
		System.out.println(a.getCreateDate());
		
	}

}
