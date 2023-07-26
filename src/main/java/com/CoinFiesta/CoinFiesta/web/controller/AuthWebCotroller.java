package com.CoinFiesta.CoinFiesta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthWebCotroller {
	
	@GetMapping("/signin")
	public String loadSignin() {
		
		return "auth/signin.html";
	}
	
	@GetMapping("/signup")
	public String loadSinup() {
		
		return "auth/signup.html";
	}
}
