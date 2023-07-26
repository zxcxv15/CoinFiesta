package com.CoinFiesta.CoinFiesta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainPageCotroller {
	
	@GetMapping({"/", "/main"})
	public String getMethod() {
		return "main.html";
	}
	
}
