package com.shop;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;
import com.shop.repository.QuestionRepository;

@SpringBootTest
class ShopThymeleafApplicationTests {

	@Autowired                                // IoC 컨테이너에 등록된 객체를 자동으로 주입 : DI 
	QuestionRepository questionRepository; 
	
	@Test
	void contextLoads() {
		
		// Question 객체 생성 
		Question q = new Question(); 
		
		//setter의 메소드를 호출 해서 값 입력 
		q.setSubject("Junit 테스트 입니다. - 제목");
		q.setContent("Junit 테스트 - 내용");
		q.setCreateDate(LocalDateTime.now());
		
		// repository를 사용해서 DB에 저장 
		questionRepository.save(q); 
		
		
	}

}
