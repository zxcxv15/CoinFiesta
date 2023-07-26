package com.CoinFiesta.CoinFiesta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardWebCotroller {
	
	@GetMapping("/write")
	public String boardWrite() {
		
		return "board/board_write.html";
	}
	
	@GetMapping("/list")
	public String boardList() {
		
		return "board/board_list.html";
	}
	
	@GetMapping("/detail/{boardcode}")
	public String boardDtail() {
		
		return "board/board_detail.html";
	}
	
	@GetMapping("/update/{boardcode}")
	public String boardUpdate() {
		
		return "board/board_update.html";
	}
}
