package com.shop.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.ItemDto;

@Controller		// IoC 컨테이너에 빈(객체) 등록 
@RequestMapping(value="/thymeleaf")       // get,post 요청 모두 처리 
public class ThymeleafExController {
	
	@GetMapping("/ex01")               // http://localhost:8082/thymeleaf/ex01
	public String thymeleafEx01(Model model) {
			//Model : 백엔드의 변수의 값을 client 뷰 페이지(타임리프) 로 전송 
		
		model.addAttribute("data", "서버에서 보내는 값입니다. "); 
		return  "thymeleafEx/thymeleafEx01";  // templates.thymeleafEx/thymeleafEx01.html
	}
	
    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";
    }


}
