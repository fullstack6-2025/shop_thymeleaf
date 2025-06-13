package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	// JpaRepository 에서 Answer Entity를 CRUD하는 메소드 가 상속됨 
		// findAll(), findById(), save(), delete()
}
