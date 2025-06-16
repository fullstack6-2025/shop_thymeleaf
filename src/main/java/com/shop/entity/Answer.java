package com.shop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20000)
    private String content;

    private LocalDateTime createDate; 

    // Answer(자식) : Many, Question(부모)  : One 
    @ManyToOne                              // 하나의 질문 많은 답변을 저장 할 수 있다.  
    private Question question;  

}
