package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.entity.Question;
import com.shop.exception.DataNotFoundException;
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
		
		// Optional 의 Question 객체를 끄집어 낼때 NULL 아닌 경우 끄집어 내야 한다. 만약에 NULL인 경우 예외 처리 필요. 
		if (question.isPresent()) {
			return question.get(); 
		}else {
			// 예외를 강제로 발생 시킴 : 프로그램이 종료 되지 않도록 예외 처리.  
			throw new DataNotFoundException("질문 데이터를 찾지 못했습니다. "); 
		}
		
	}

}
