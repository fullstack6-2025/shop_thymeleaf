package com.shop.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
	
	// 상품 정보를 처리하는 Dto : client   ===>  dto ====> Entity ==> DB 
	private Long id; 
	private String ItemNm; 
	private Integer price; 
	private String ItemDetail;
	private String sellStatCd; 
	private LocalDateTime regTime; 
	private LocalDateTime updateTime; 

}
