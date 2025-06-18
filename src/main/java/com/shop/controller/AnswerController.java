package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.AnswerForm;
import com.shop.entity.Question;
import com.shop.service.AnswerService;
import com.shop.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	// client => controller => service => repository => entity => db 
	
	// 빈주입 
	private final AnswerService answerService;
	private final QuestionService questionService; 
	
	// 답변 등록 
	@PostMapping("/create/{id}")
	public String createAnswer(
			Model model, 
			@PathVariable("id") Integer id , 
//			@RequestParam("content") String content
			
			@Valid AnswerForm answerForm, 
			BindingResult bindingResult
			
			) {
		
		// 답변을 넣은 질문을 가지고 온다. 
		Question question = questionService.getQuestion(id); 
		
		/*
		System.out.println("답글 등록 요청 성공!!!!");
		System.out.println("답글을 위한 question_id : " + id);
		System.out.println("답글 내용 : " + content);
		*/ 
		
		// 만약에 content의 값이 비어있을때  question_detail 페이지 
		if (bindingResult.hasErrors()) {
			model.addAttribute("question", question); 
			return "question_detail";
		}
		
		
		// 답변을 DB에 저장
		answerService.create(question, answerForm.getContent());
		
		
		return String.format("redirect:/question/detail/%s", id) ; 
		
	}
	

}
