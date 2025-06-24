package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Select_Question_Test {
	
	@Autowired
	QuestionRepository questionRepository;

	@Test
	void selectQuestionTest() {
		// Question 객체를 가지고와서 각 필드의 내용을 출력 
		Question q = new Question(); 
		Optional<Question> _q = 
				questionRepository.findById(1010); 
		
		if (_q.isPresent()) {
			q = _q.get(); 
		}
		
		System.out.println(q.getId());
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		System.out.println(q.getCreateDate());
		
		System.out.println(q.getAuthor().getId());
		System.out.println(q.getAuthor().getUsername());
		System.out.println(q.getAuthor().getEmail());
		System.out.println(q.getAuthor().getPassword());
			
		
	}
}
