package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shop.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

// Ioc 컨테이너에 빈(객체)등록 어노테이션 
/*
 * 		@Component : 일반 클래스를 빈 등록
 * 		@Controller : Controller 클래스를 빈등록
 * 		@Service	: Service 클래스를 빈등록 
 * 		@Repository : Repository 클래스를 빈등록  
 */
// DI (Dependancy Injection) : 의존성 주입 , IoC 컨테이너의 빈(객체)를 변수에 주입 
/*
 * 		@Autowired		<== 타입을 가져와서 주입 , 테스트 코드에서 사용, 필드위에서 선언
 * 		@RequiredArgsContructor 	<== 생성자 주입 (보안강함), 클래스에서 선언 , final 에 설정된 필드에 객체를 주입
 * 			private final QuestionRepository questionRepository; 
 * 				
 */

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	
	


}
