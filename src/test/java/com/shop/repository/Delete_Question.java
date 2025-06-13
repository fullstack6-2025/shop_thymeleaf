package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Delete_Question {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void deleteQuestion() {
		//1. delete할 레코드를 가지고 와서 Question q Entity 에 넣는다. 
		Optional<Question> oq = 
				questionRepository.findById(100); 
		
		Question q = new Question();  
		if (oq.isPresent()) {
			q = oq.get(); 
		}
		
		//2. Repository 의  delete(q) 넣어서 제거 한다. 
		questionRepository.delete(q);
		
		
	}

}
