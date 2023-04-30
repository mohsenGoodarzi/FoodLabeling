package com.nutrition.information.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nutrition.information.entities.Unit;
import com.nutrition.information.entities.Warning;
import com.nutrition.information.services.WarningService;

@Controller
@RequestMapping("/Warnings")
public class WarningController {

	@Autowired
	private WarningService warningService;
	
	@GetMapping("List")
	public ModelAndView list() {
		ModelAndView modelAndView=new ModelAndView();
		List<Warning> warnings = warningService.getAll();
		modelAndView.addObject("warnings",warnings);
		modelAndView.setViewName("/warnings/list.html");
		return modelAndView;
	}
	@GetMapping("Create")
	public ModelAndView create() {
		Warning warning = new Warning();
		ModelAndView modelAndView = new ModelAndView("/warnings/create.html","warning",warning);
		return modelAndView;
	}
	@PostMapping("Create")
	public ModelAndView create(@ModelAttribute Warning warning, RedirectAttributes redirectAttributes ) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			warningService.add(warning);
		} catch (Exception e) {
			//either log or use actuator here and don't give away the error
			redirectAttributes.addFlashAttribute("error",e.getMessage());
			modelAndView.setViewName("redirect:/Error");
			return modelAndView ;
		}
		modelAndView.setViewName("redirect:/Units");
		return modelAndView;
	}
	
	@GetMapping("Edit/{warningId}")
	public ModelAndView edit(@PathVariable("warningId") String warningId) {
		Warning warning;
		ModelAndView modelAndView = new ModelAndView();
		try {
			warning = warningService.getWarning(warningId);
			 modelAndView.addObject("warning",warning);
			modelAndView.setViewName("/warning/edit.html");
		} catch (Exception e) {
			modelAndView.setViewName("redirect:/Error");
		}
		return modelAndView;
}
	@GetMapping("Delete/{warningId}")
	public ModelAndView delete(@PathVariable("warningId") String warningId) {
		ModelAndView modelAndView = new ModelAndView();
		
		Warning warning = warningService.getWarning(warningId);
		if (warning == null) {
			// the Path you are looking for it does not exist.
			
			return null;
		}
		modelAndView.addObject("warning", warning);
		modelAndView.setViewName("/warnings/delete.html");
		return modelAndView;
	}
}