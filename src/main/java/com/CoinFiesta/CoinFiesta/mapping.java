package com.CoinFiesta.CoinFiesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
	
	@GetMapping("/test")
	public String test() {
		try {
			System.out.println(rep.test());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test.html";
	}
	
	
}
