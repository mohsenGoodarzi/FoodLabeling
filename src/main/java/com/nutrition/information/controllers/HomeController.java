package com.nutrition.information.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/", "/Home" })
	public String index() {
		return "/Home/index.html";
	}

}
