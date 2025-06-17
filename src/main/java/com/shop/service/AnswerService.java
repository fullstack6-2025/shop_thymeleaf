package com.shop.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	
	// 답글 등록 (insert, update, delete 리턴이 없다), (select 인 경우는 select 한 값을 돌려 줘야한다. ) 
	public void create (Question question, String content ) {
		Answer answer = new Answer(); 
		
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		
		answerRepository.save(answer); 
		
		System.out.println("답변이 성공적으로 잘 저장되었습니다. ");
		
	}
}
