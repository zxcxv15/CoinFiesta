package com.CoinFiesta.CoinFiesta.web.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/number")
public class NumberConroller {
	public ResponseEntity<?> addNumber(){
		System.out.println("숫자 추가");
		return new ResponseEntity<>("작성 성공", HttpStatus.OK);
	}
}
