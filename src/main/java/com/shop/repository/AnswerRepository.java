package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	// JpaRepository 에서 Answer Entity를 CRUD하는 메소드 가 상속됨 
		// findAll(), findById(), save(), delete()
	
	// 질문에 대한 답변만 페이징 처리 
	Page<Answer> findByQuestion(Question question, Pageable pageable); 
}
