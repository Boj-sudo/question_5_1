package com.bitnine.assessment.tsietsimaboa.control;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitnine.assessment.tsietsimaboa.controller.dto.UserRegistrationDto;
import com.bitnine.assessment.tsietsimaboa.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private UserService user_service;
	
	public RegistrationController(UserService user_service) {
		super();
		this.user_service = user_service;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registration_dto, BindingResult binding_result) {
		
		if(binding_result.hasErrors()) {
			return "registration";
		}
		
		user_service.saveUser(registration_dto);
		
		return "redirect:/registration?success";
	}
}
