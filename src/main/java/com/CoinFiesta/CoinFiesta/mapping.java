package com.CoinFiesta.CoinFiesta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapping {

	@Autowired
	private testRep rep;

	@GetMapping("/")
	public String getMethod() {
		return "index.html";
	}

	@GetMapping("/hoga")
	public String hoga() {
		return "hoga.html";
	}

	@GetMapping("/board/write")
	public String board_write() {
		return "board/write.html";
	}
}
