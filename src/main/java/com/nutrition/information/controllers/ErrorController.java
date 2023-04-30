package com.nutrition.information.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@GetMapping("/Error")
	public String error(Model model,@ModelAttribute Error error) {
		model.addAttribute("error",  error.getMessage());
	return "/errors/error.html";
} 
	
}
