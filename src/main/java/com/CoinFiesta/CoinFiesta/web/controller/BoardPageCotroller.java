package com.CoinFiesta.CoinFiesta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardPageCotroller {
	
	@GetMapping("/write")
	public String boardWrite() {
		
		return "board/write.html";
	}
	
	@GetMapping("/list")
	public String boardList() {
		
		return "board/list.html";
	}
	
	@GetMapping("/detail/{boardcode}")
	public String boardDtail() {
		
		return "board/detail.html";
	}
}
