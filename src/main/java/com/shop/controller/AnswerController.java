package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.service.AnswerService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	// client => controller => service => repository => entity => db 
	
	// 빈주입 
	private final AnswerService answerService;
	
	// 답변 등록 
	@PostMapping("/create/{id}")
	public String createAnswer(
			Model model, 
			@PathVariable("id") Integer id , 
			@RequestParam("content") String content
			) {
		
		System.out.println("답글 등록 요청 성공!!!!");
		System.out.println("답글을 위한 question_id : " + id);
		System.out.println("답글 내용 : " + content);
		
		return null ; 
		
	}
	

}
