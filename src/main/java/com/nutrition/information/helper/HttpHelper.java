package com.nutrition.information.helper;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nutrition.information.entities.ErrorView;

public class HttpHelper {
	public ModelAndView redirect(ErrorView error,ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error",error);
		modelAndView.setViewName("redirect:/Error");
		return modelAndView ;
	}
}
