package com.CoinFiesta.CoinFiesta.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardPageCotroller {
	
	@GetMapping("/write")
	public String board_write() {
		
		return "board/write.html";
	}
}
