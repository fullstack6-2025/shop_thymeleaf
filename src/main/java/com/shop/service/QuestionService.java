package com.shop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shop.entity.Question;
import com.shop.entity.SiteUser;
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
	
	// 질문 등록 
	public void create(String subject, String content, SiteUser user ) {
		Question question = new Question(); 
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		question.setAuthor(user);
		
		questionRepository.save(question); 
	}
	
	// 질문 리스트 (페이징 처리된) 
    public Page<Question> getList(int page) {
    	
    	// 정렬하는 sort 객체 생성 
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
    	
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    // 질문 수정 메소드
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
    
    // 질문 삭제 메소드 
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

    // 추천 등록 메소드 
    public void vote(Question question, SiteUser siteUser) {
    	
        question.getVoter().add(siteUser);
        
        this.questionRepository.save(question);
    }



}
