package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapping {
	@GetMapping("/222")
	public String test2() {
		return "templates/test2.html";
	}
}
