package com.shop.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class Insert_1000_Answer {
	
	// 답글을 저장시 어떤 질문에 대한 답글인지 
	@Autowired
	private QuestionRepository questionRepository; 
	
	@Autowired
	private AnswerRepository answerRepository; 
	
	@Test
	void insert1000Answer() {
		
		// 답변을 저장할 Question 객체를 가지고 온다. 
		Optional<Question> oq = 
				questionRepository.findById(1005); 
		Question q = new Question(); 
		if (oq.isPresent()) {
			q = oq.get(); 
		}
		
 
		for (int i = 1 ; i <= 1000 ; i++) {
			Answer a = new Answer();
			a.setContent("답변2 - " + i);
			a.setCreateDate(LocalDateTime.now());
			a.setQuestion(q);
			
			answerRepository.save(a); 
		}
		
	}
}
