package com.shop.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Select_All_Question {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void selectAllQuestion() {
		
		List<Question> questionList = 
				questionRepository.findAll(); 
		
		System.out.println("레코드의 갯수 : " + questionList.size());
		
		// for 문을 사용해서 List에 각 방의 내용을 끄집어 내서 출력
		Question q = new Question (); 
		
		System.out.println("=====For 문을 사용해서 출력 ===============");
		for (int i = 0 ; i < questionList.size() ; i++) {
			q = questionList.get(i); 
			System.out.print(q.getId() + "\t");
			System.out.print(q.getSubject() + "\t");
			System.out.print(q.getContent() + "\t");
			System.out.print(q.getCreateDate());
			System.out.println();
		}
		
		System.out.println("=====Enhanced For 문으로 출력 ===========");
		for (Question aq : questionList) {
			System.out.print(aq.getId() + "\t");
			System.out.print(aq.getSubject() + "\t");
			System.out.print(aq.getContent() + "\t");
			System.out.print(aq.getCreateDate() );
			System.out.println();
		}
		
	}
	
}
