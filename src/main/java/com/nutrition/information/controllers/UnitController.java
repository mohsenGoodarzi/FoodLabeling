package com.nutrition.information.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nutrition.information.entities.Unit;
import com.nutrition.information.services.UnitService;

@Controller
public class UnitController {
	@Autowired
	private UnitService unitService;

	@GetMapping("/Units")
	public ModelAndView allUnits() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("units", unitService.getAllUnits());
		modelAndView.setViewName("/units/All.html");
		return modelAndView;
	}

	@GetMapping("/Units/Create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		Unit unit = new Unit();
		modelAndView.addObject(unit);
		modelAndView.setViewName("/units/Create.html");
		return modelAndView;
	}

	@PostMapping("/Units/Create")
	public ModelAndView create(@ModelAttribute("unitId") String unitId, @ModelAttribute("toGram") double toGram, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			unitService.add(new Unit(unitId, toGram));
		} catch (Exception e) {

			//modelAndView.addObject("Error",new Error(e.getMessage()));
			// forward lets you to make post request to an end point
			redirectAttributes.addFlashAttribute("Error", new Error(e.getMessage()));
			modelAndView.setViewName("redirect:/Errors");
			return modelAndView ;
		}

		modelAndView.setViewName("redirect:/Units");
		return modelAndView;
	}
	@GetMapping("/Units/Edit/{unitId}")
	public ModelAndView edit(@ModelAttribute("unitId") String unitId) {
		ModelAndView modelAndView = new ModelAndView();
		Unit unit = unitService.getUnit(unitId);
		modelAndView.addObject(unit);
		modelAndView.setViewName("/units/Edit.html");
		return modelAndView;
	}

	@PostMapping("/Units/Edit")
	public ModelAndView edit(@ModelAttribute("unitId") String unitId, @ModelAttribute("toGram") double toGram, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Unit unit = unitService.getUnit(unitId);
			
			unit.setToGram(toGram);
			unitService.edit(unit);
		} catch (Exception e) {

			 modelAndView.addObject("Error",new Error(e.getMessage()));
			// forward lets you to make post request to an end point
			
			//redirectAttributes.addFlashAttribute("Error", new Error(e.getMessage()));
			 modelAndView.setViewName("redirect:/Errors");
			return modelAndView;
		}

		modelAndView.setViewName("redirect:/Units");
		return modelAndView;
	}
	@GetMapping("/Units/Delete/{unitId}")
	public ModelAndView delete(@ModelAttribute("unitId") String unitId) {
		ModelAndView modelAndView = new ModelAndView();
		Unit unit = unitService.getUnit(unitId);
		modelAndView.addObject(unit);
		modelAndView.setViewName("/units/delete.html");
		return modelAndView;
	}

	@PostMapping("/Units/Delete")
	public ModelAndView delete(@ModelAttribute("unitId") String unitId, @ModelAttribute("toGram") double toGram) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			System.out.println("Removing the unit Id  "+ unitId);
			unitService.remove(unitId);
		} catch (Exception e) {

			modelAndView.addObject(new Error(e.getMessage()));
			// forward lets you to make post request to an end point
			modelAndView.setViewName("forward:/Errors");
			return modelAndView;
		}

		modelAndView.setViewName("redirect:/Units");
		return modelAndView;
	}
	@GetMapping("/Errors")
	public ModelAndView error(@ModelAttribute Error error) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error", error.getMessage());
		System.out.println("Error: " + error.getMessage());
		modelAndView.setViewName("/errors/of.html");
		return modelAndView;
	}
}
