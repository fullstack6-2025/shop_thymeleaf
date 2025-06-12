package com.shop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.ItemDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @GetMapping(value = "/ex04")					// http://localhost:8082/thymeleaf/ex04
    public String thymeleafExample04(Model model){

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1;i<=10;i++){

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx04";
    }

    @GetMapping(value = "/ex05")
    public String thymeleafExample05(){
        return "thymeleafEx/thymeleafEx05";
    }
    
    @GetMapping(value = "/ex06")	//http://localhost:8082/thymeleaf/ex06?param1=홍길동&param2=50
    public String thymeleafExample06(
    		@RequestParam(name="param1", defaultValue="이름없음")
    		String param1, 
    		@RequestParam(name="param2", defaultValue="0")
    		String param2, Model model){
    	
    	System.out.println(param1);
    	System.out.println(param2);
    	
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleafEx/thymeleafEx06";
    }
    
    @GetMapping("/ex06-1")
    public String formView () {
    	return "thymeleafEx/thymeleafEx06-1"; 
    }

    @GetMapping("/ex06-2")
    public String formPrint(
    		@RequestParam("id") String id , 
    		@RequestParam("pwd") String pwd
    		)
    {
    	System.out.println("get id : " + id);
    	System.out.println("get pwd : " + pwd);
    	return "redirect:/thymeleaf/ex05" ; 	// http://localhost:8082/thymeleaf/ex05
    }
    
    @PostMapping("/ex06-3")					// http://localhost:8082/thymeleaf/ex06-1
    public String formPost(
    		@RequestParam("id") String id , 
    		@RequestParam("pwd") String pwd
    		) {
    	
    	System.out.println("post id : " + id);
    	System.out.println("post pwd : " + pwd);
    	
        return "redirect:/thymeleaf/ex05";   // http://localhost:8082/thymeleaf/ex05
    }
    
    @GetMapping(value = "/ex07")			// http://localhost:8082/thymeleaf/ex07
    public String thymeleafExample07(){
        return "thymeleafEx/thymeleafEx07";
    }

    

}
