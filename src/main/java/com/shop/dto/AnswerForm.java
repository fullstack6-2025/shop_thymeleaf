package com.shop.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	
	@NotEmpty(message="답글은 반드시 입력 해야 등록이 됩니다.")
	private String content; 

}
