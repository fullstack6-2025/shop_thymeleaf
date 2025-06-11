package com.shop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    
    @GetMapping(value = "/ex03")
    public String thymeleafExample03(Model model){

    	// List 는 for 블락 밖에서 선언 
        List<ItemDto> itemDtoList = new ArrayList<>();
        //ItemDto itemDto = new ItemDto();
        
        for(int i=1;i<=100;i++){
        	// ItemDto 객체는 for 문 블락 내부에서 선언 
            // itemDtoList = new ArrayList<>();
            
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx03";
    }



}
