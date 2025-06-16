package com.shop.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class Insert_Answer2 {
	
	@Autowired
	AnswerRepository answerRepository; 
	
	@Autowired
	QuestionRepository questionRepository; 
	
	@Test
	void insertAnswer2() {
		// 1. 어떤 질문에 대한 답글 인지 (답변글을 넣을 Question 객체를 가지고 와야함) 
		Optional<Question> oq = 
				questionRepository.findById(4); 
		
		Question q = new Question(); 
		
		if (oq.isPresent()) {
			q = oq.get(); 
		}
		
		// 2. Answer 에 답변을 저장 
		Answer a = new Answer(); 
		
		a.setContent("4번 글에 대한 답변 4");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q); 
		
		// 3. AnswerRepository save() 를 사용해서 저장 
		
		answerRepository.save(a); 
		
	}

}
