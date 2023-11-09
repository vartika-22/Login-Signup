package com.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.controller.dto.UserRegistrationDto;
import com.registration.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping("/registration")
	public String showRegistraionForm() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registrationUserAcount(@ModelAttribute("user")UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost() {
	    // Process login form submission
	    return "redirect:/dashboard"; // Redirect to the home page after successful login
	}
	
	@GetMapping("/")
	public String dashbord() {
		return "dashboard";
	}
	
}
