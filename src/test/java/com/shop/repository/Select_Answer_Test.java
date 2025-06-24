package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;

@SpringBootTest
public class Select_Answer_Test {

	// Answer 에 마지막 레코드를 검색해서  질문내용[출력], 답변내용[출력], 작성자[출력] 
	@Autowired
	AnswerRepository answerRepository; 
	
	@Test
	void selectAnswerTest() {
		Answer a = new Answer(); 
		
		Optional<Answer> _a = 
				answerRepository.findById(4030); 
		
		if (_a.isPresent()) {
			a = _a.get(); 
		}
		
		//답변 정보 출력 
		System.out.println(a.getId());
		System.out.println(a.getContent());           // 답변 내용
		
		//질문 정보 출력 
		System.out.println(a.getQuestion().getSubject());   // 질문 제목
		System.out.println(a.getQuestion().getContent());   // 질문 내용
		
		//답글단 사용자 정보 출력 
		
		System.out.println(a.getAuthor().getUsername());   // 답변을 단 사용자 정보 출력 
		
	}
}
