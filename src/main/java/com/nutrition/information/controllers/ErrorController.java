package com.nutrition.information.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.nutrition.information.entities.ErrorView;

@Controller
public class ErrorController {

	@GetMapping("/Error")

	public String error(Model model,@ModelAttribute ErrorView error) {
		model.addAttribute("error", error);
	return "/errors/error.html";
} 
	
}
