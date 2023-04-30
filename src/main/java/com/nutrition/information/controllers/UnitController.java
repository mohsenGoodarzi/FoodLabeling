package com.nutrition.information.controllers;

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
import com.nutrition.information.services.UnitService;

@Controller
@RequestMapping("/Units")
public class UnitController {
	@Autowired
	private UnitService unitService;

	@GetMapping({"/","All"})
	public ModelAndView all() {
		ModelAndView modelAndView = new ModelAndView("/units/All.html","units", unitService.getAllUnits());
		return modelAndView;
	}

	@GetMapping("Create")
	public ModelAndView create() {
		Unit unit = new Unit();
		ModelAndView modelAndView = new ModelAndView("/units/Create.html","unit",unit);

		return modelAndView;
	}

	@PostMapping("Create")
	public ModelAndView create(@ModelAttribute("unit") Unit unit, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			unitService.add(unit);
		} catch (Exception e) {
			//either log or use actuator here and don't give away the error
			redirectAttributes.addFlashAttribute("error",e.getMessage());
			modelAndView.setViewName("redirect:/Error");
			return modelAndView ;
		}
		
		modelAndView.setViewName("redirect:/Units/");
		return modelAndView;
	}
	@GetMapping("Edit/{unitId}")
	public ModelAndView edit(@PathVariable("unitId") String unitId, RedirectAttributes redirectAttributes ) {
		ModelAndView modelAndView = new ModelAndView();
		Unit unit = unitService.getUnit(unitId);
		if (unit==null) {
			//either log or use actuator here and don't give away the error
			redirectAttributes.addFlashAttribute("error","Not Found");
			modelAndView.setViewName("redirect:/Error");
			return modelAndView ;
		}
		modelAndView.addObject(unit);
		modelAndView.setViewName("/units/Edit.html");
		return modelAndView;
	}

	@PostMapping("Edit")
	public ModelAndView edit(@ModelAttribute("unit") Unit unit, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			unitService.edit(unit);
		} catch (Exception e) {

			//either log or use actuator here and don't give away the error
			redirectAttributes.addFlashAttribute("error",e.getMessage());
			modelAndView.setViewName("redirect:/Error");
			return modelAndView ;
		}

		modelAndView.setViewName("redirect:/Units/");
		return modelAndView;
	}
	@GetMapping("Delete/{unitId}")
	public ModelAndView delete(@PathVariable("unitId") String unitId, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		Unit unit = unitService.getUnit(unitId);
		if (unit==null) {
			//either log or use actuator here and don't give away the error
			redirectAttributes.addFlashAttribute("error","Not Found");
			modelAndView.setViewName("redirect:/Error");
			return modelAndView ;
		}
		modelAndView.addObject("unit",unit);
		modelAndView.setViewName("/units/delete.html");
		return modelAndView;
	}
// improvement required. This should become similar to Edit 
	@PostMapping("Delete/{unitId}") 
	public ModelAndView deleteConfirmed(@ModelAttribute("unit") Unit unit) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			System.out.println("Removing the unit Id  "+ unit.getUnitId());
			unitService.remove(unit.getUnitId());
		} catch (Exception e) {

			modelAndView.addObject(new Error(e.getMessage()));
			// forward lets you to make post request to an end point
			modelAndView.setViewName("redirect:/Errors");
			return modelAndView;
		}

		modelAndView.setViewName("redirect:/Units/");
		return modelAndView;
	}
}
