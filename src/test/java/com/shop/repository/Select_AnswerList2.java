package com.shop.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class Select_AnswerList2 {
	
	@Autowired
	QuestionRepository questionRepository; 
	
	@Transactional
	@Test
	void selectAnswerList2() {
		
		Optional<Question> oq = 
				questionRepository.findById(4); 
		
		Question q = new Question(); 
		
		if (oq.isPresent()) {
			q = oq.get(); 
		}
		
		System.out.println("== 끄집어낸 Question 객체 정보 ====");
		System.out.println(q.getId());
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		System.out.println(q.getCreateDate());
		
		List<Answer> answerList = 
				q.getAnswerList(); 
		
		System.out.println("== for 문을 사용해서 답변을 출력 : ");
		for (int i = 0 ; i < answerList.size(); i++) {
			Answer a = new Answer(); 
			a = answerList.get(i); 
			System.out.print(a.getId() + "\t");
			System.out.print(a.getContent() + "\t");
			System.out.print(a.getCreateDate() + "\t");
			System.out.println();
			
		}
		
	}

}
