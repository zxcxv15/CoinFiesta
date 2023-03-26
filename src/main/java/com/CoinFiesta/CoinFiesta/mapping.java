package com.CoinFiesta.CoinFiesta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapping {
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	
	
	@GetMapping("/")
	public String getMethod() {
		
		

		
		return "index";
	}
	
}
