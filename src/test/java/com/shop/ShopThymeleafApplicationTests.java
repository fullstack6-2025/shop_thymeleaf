package com.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.repository.QuestionRepository;

@SpringBootTest
class ShopThymeleafApplicationTests {

	@Autowired                                // IoC 컨테이너에 등록된 객체를 자동으로 주입 : DI 
	QuestionRepository questionRepository; 
	
	@Test
	void contextLoads() {
		
	}

}
