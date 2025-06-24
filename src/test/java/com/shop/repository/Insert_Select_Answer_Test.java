package com.shop.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.entity.SiteUser;

@SpringBootTest
public class Insert_Select_Answer_Test {
	
	// 1. 마지막 질문을 참조해서 답변을 등록 하세요. admin 으로 답변을 등록 
	
	// 2. 등록된 답변을 출력 : 답변내용, 질문제목, 질문내용, 글쓴이를 출력 
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	QuestionRepository questionRepository; 
	@Autowired
	UserRepository userRepository; 
	
	@Test
	@DisplayName("1. 마지막 질문을 참조해서 답변을 등록")
	void insertSelectAnswerTest() {
		// 질문 객체를 가져 와야한다. 
		Optional<Question> _q = 
				questionRepository.findById(1010); 
		
		Question q = new Question(); 
		
		if (_q.isPresent()) {
			q = _q.get(); 
		}
		
		// 사용자 객체를 가져와야 함.
		Optional<SiteUser> _u = 
				userRepository.findByusername("admin"); 
		SiteUser u = new SiteUser(); 
		
		if (_u.isPresent()) {
			u = _u.get(); 
		}
		
		// 답변을 저장할 Answer Entity 객체 선언 
		Answer a = new Answer(); 
		
		a.setContent("마지막 글의 대한 답변");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		a.setAuthor(u);
		
		// 저장 
		
		answerRepository.save(a); 
			
	}
	
	@Test
	@DisplayName("2. 등록된 답변을 출력")
	void selectAnswer() {
		Optional<Answer> _a = 
				answerRepository.findById(4031); 
		Answer a = new Answer(); 
		
		if ( _a.isPresent()) {
			a = _a.get(); 
		}
		
		//답변내용, 질문제목, 질문내용, 글쓴이를 출력
		System.out.println(a.getContent());		// 답글 내용
		System.out.println(a.getQuestion().getSubject());   // 질문 제목
		// 질문 작성자 출력 
		System.out.println(a.getQuestion().getAuthor().getUsername()); // 질문 작성자
		System.out.println(a.getQuestion().getContent());   // 질문 내용
		System.out.println(a.getAuthor().getUsername());    // 답글 작성자  
		
		
	}

}
