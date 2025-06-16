package com.shop.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class Insert_Answer {
	
	// 답변 테이블에 값넣기 
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerRepository; 
	
	
	@Test
	 void insertAnswer() {
		
		//1. 답변 테이블에 값을 넣기 위해서는 어떤 질문에 대한 답변인지 가지고 와야 한다. 
		//   답변을 저장 할 Question객체를 먼저 가져와야 한다. 
		Optional<Question> oq = 
				questionRepository.findById(1); 
		
		Question q = new Question(); 
		if (oq.isPresent()) {
			q = oq.get(); 
		}
		
		// 2. Answer 객체에 setter 를 사용해서 답글을 입력한다. 
		Answer a = new Answer(); 
		a.setContent("1 번 질문에 대한 답변 1");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		
		// 3. AnswerRepository를 사용한 저장 
		
		answerRepository.save(a); 
		 
	 }

}
