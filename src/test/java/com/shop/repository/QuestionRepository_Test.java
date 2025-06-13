package com.shop.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class QuestionRepository_Test {
	
	@Autowired
	QuestionRepository questionRepository; 
	
	@Autowired
	AnswerRepository answerRepository; 
	
	@Test
	void insertTest() {
		// 객체 생성 
		Question q = new Question(); 
		Answer a = new Answer(); 
		
		// 객체에 값을 입력 : setter 
		q.setSubject("JPA 가 무엇인가요? - 제목");
		q.setContent("JPA - 내용" );
		q.setCreateDate(LocalDateTime.now());
		
		a.setContent("JPA는 ORM입니다");
		a.setCreateDate(LocalDateTime.now());
		
		// 레파지토리의 메소드를 사용해서 db 에 값을 저장 
		questionRepository.save(q);
		answerRepository.save(a); 
		
	}

}
