package com.bitnine.assessment.tsietsimaboa.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}
}
