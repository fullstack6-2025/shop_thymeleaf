package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Select_Test {
	
	@Autowired
	QuestionRepository questionRepository; 
	
	@Test
	void selectTest() {
		
		Question q = new Question(); 
		
		Optional<Question> oq = 
				questionRepository.findById(2); 
		
		if (oq.isPresent()) {
			q = oq.get(); 
		}
		
		System.out.println(q.getId());		
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		System.out.println(q.getCreateDate());
		
	}

}
