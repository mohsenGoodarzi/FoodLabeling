package com.nutrition.information.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("Login")
	public String login() {
		return "/Login/login.html";
	}

	@GetMapping("/AccessDenied")
	public String accessDenied() {

		return "/errors/access-denied.html";
	}

}
