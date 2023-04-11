package com.CoinFiesta.CoinFiesta.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardPageCotroller {
	
	@GetMapping("/write")
	public String board_write() {
		
		return "board/write.html";
	}
	
	@GetMapping("/list")
	public String board_list() {
		
		return "board/list.html";
	}
	
	@GetMapping("/detail/{boardcode}")
	public String board_detail() {
		
		return "board/detail.html";
	}
}
