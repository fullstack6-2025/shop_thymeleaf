package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.entity.Question;
import com.shop.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	//question 테이블의 모든 값을 출력 하는 메소드 
	// 질문 리스트 를 처리하는 메소드 
	public List<Question> getList() {
		
		System.out.println( " question 서비스 잘 요청됨 ");
		return questionRepository.findAll() ; 
	}
	
	// 질문 상세 를 처리하는 메소드
	public Question getQuestion(Integer id) {
		Optional<Question> question = 
				questionRepository.findById(id); 
		
		return question.get(); 
	}

}
