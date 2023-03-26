package com.CoinFiesta.CoinFiesta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapping {
	
	@GetMapping("/")
	public String getMethod() {
		return "index";
	}
	
	
	@GetMapping("/hoga")
	public String hoga() {
		return "hoga";
	}
	
}
