package com.shop.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity		// DB의 테이블과 연결되어 있는 클래스 : 자바 클래스가 테이블과 연결 
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	private String subject;

	@Column(length = 20000)
	private String content;

	private LocalDateTime createDate;
	
	private LocalDateTime modifyDate;
	
    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;

	
	// 질문에 대한 답변 글이 저장된 리스트 
	@OneToMany(mappedBy="question" , cascade=CascadeType.REMOVE)
	private List<Answer> answerList; 

}
