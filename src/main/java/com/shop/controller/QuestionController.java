package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.ShopThymeleafApplication;
import com.shop.entity.Question;
import com.shop.repository.QuestionRepository;
import com.shop.service.QuestionService;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

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

// Controller 의 역활 : 1. client의 요청을 받는다. => 2. 비즈니스 로직 처리 => 3. 뷰페이지 전송 
@RequestMapping("/question")		// get, post 
@RequiredArgsConstructor
@Controller
public class QuestionController {
	// MVC 모델로 처리 
	// client 요청 => Controller => Service => Repository => Entity => DB 
		// service : Controller에서 Repository를 접근 할 경우 보안의 이슈 발생 
					// Controller에서 직접 비즈니스 로직을 구현할 경우 중복코드가 많이 발생 될수 있다. 
					// Service : 비즈니스 로직을 구현하면 중복된 코드와 보안을 강화 할 수 있다. 
					// 유지 보수를 쉽게 할 수 있다. 
//	private final QuestionRepository questionRepository;

	private final QuestionService questionService; 
	
	// 질문 리스트 페이지
	@GetMapping("/list")				//http://localhost:8082/question/list    ( 1.client 요청 ) 
	public String list(Model model) {
		
		// 2. 비즈니스 로직 처리 (백엔드 로직 처리, ) 
		List<Question> questionList = 
				questionService.getList(); 
		
		// 모델 객체에 변수의 값을 담아서 clinet 페이지로 전송 
		model.addAttribute("questionList", questionList); 
		
		
//		System.out.println("컨트롤러 요청 성공 ");
		return "question_list";                    // 3. 뷰 페이지 전송 
	}
	
	// 질문 상세 페이지 
	@GetMapping("/detail/{id}")
	public String detail(Model model,
			@PathVariable("id") Integer id 
			) {
		
		//System.out.println("id 변수의 값 : " + id);
		// 넘겨받은 id 값을 가지고 QuestionRepository.findById(id); 
		Question question = 
				questionService.getQuestion(id);
		/*
		System.out.println(question.getSubject());
		System.out.println(question.getContent());
		System.out.println(question.getId());
		*/
		model.addAttribute("question", question); 
		
		return "question_detail"; 
	}
	
	// 질문 등록 뷰 페이지 처리 
	
	@GetMapping("/create")
	public String questionCreate() {
		
		return "question_form"; 
	}
	
	// 질문 등록을 받아서 DB에 저장 
	@PostMapping("/create")
	public String questionCreat(
			@RequestParam(value="subject") String subject, 
			@RequestParam("content") String content
			) {
		
		System.out.println("질문 등록 Post 요청 성공 ");
		System.out.println(subject);
		System.out.println(content);
		
		
		// 질문을 DB에 저장후 질문 리스트 페이지로 이동 
		return "redirect:/question/list"; 
	}
	


}
