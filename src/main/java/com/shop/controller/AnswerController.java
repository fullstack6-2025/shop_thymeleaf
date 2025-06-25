package com.shop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.shop.dto.AnswerForm;
import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.entity.SiteUser;
import com.shop.service.AnswerService;
import com.shop.service.QuestionService;
import com.shop.service.UserService;

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
	private final UserService userService;
	
	// 답변 등록 
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}")
	public String createAnswer(
			Model model, 
			@PathVariable("id") Integer id , 
//			@RequestParam("content") String content
			
			@Valid AnswerForm answerForm, 
			BindingResult bindingResult,
			Principal principal	
			) {
		// principal : client 의 로그인한 계정을 서버에서 가지고 오는 객체 
		if ( principal.getName() != null) {
			System.out.println("Principal : " + principal.getName());
		}
		// 답변을 넣은 질문을 가지고 온다. 
		Question question = questionService.getQuestion(id); 
		// 답변에 넣을 SiteUser 객체를 가지고 온다. 
		SiteUser siteUser = this.userService.getUser(principal.getName());
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
		answerService.create(question, answerForm.getContent(), siteUser );
		
		
		return String.format("redirect:/question/detail/%s", id) ; 
		
	}
	
	// 답변 수정 (get)
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String answerModify(AnswerForm answerForm, @PathVariable("id") Integer id, Principal principal) {
        Answer answer = this.answerService.getAnswer(id);
        if (!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        answerForm.setContent(answer.getContent());
        return "answer_form";
    }

	// 답변 수정 (post)
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String answerModify(@Valid AnswerForm answerForm, BindingResult bindingResult,
            @PathVariable("id") Integer id, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "answer_form";
        }
        Answer answer = this.answerService.getAnswer(id);
        if (!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.answerService.modify(answer, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
    }

    // 답변 삭제 
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String answerDelete(Principal principal, @PathVariable("id") Integer id) {

        Answer answer = this.answerService.getAnswer(id);

        if (!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }

        this.answerService.delete(answer);

        return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String answerVote(Principal principal, @PathVariable("id") Integer id) {
    	
        Answer answer = this.answerService.getAnswer(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        
        this.answerService.vote(answer, siteUser);
        
        return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
    }


    

}
