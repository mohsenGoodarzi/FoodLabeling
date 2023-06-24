package com.nutrition.information.controllers;

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

import com.nutrition.information.entities.DishType;
import com.nutrition.information.entities.ErrorView;
import com.nutrition.information.services.DishTypeService;

@Controller
@RequestMapping("/DishTypes")
public class DishTypeController {

	@Autowired
	private DishTypeService dishTypeService;

	@GetMapping({ "All" })
	public ModelAndView all() {
		List<DishType> dishTypes = dishTypeService.all();

		ModelAndView modelAndView = new ModelAndView("dish-types/list.html", "dishTypes", dishTypes);
		return modelAndView;
	}

	@GetMapping("Create")
	public ModelAndView create() {
		DishType dishType = new DishType();
		ModelAndView modelAndView = new ModelAndView("dish-types/create.html", "dishType", dishType);
		return modelAndView;
	}

	// When there is a self referencing, @ModelAttribute can help with attribute as well.
	// No need to go for full model
	@PostMapping("Create")
	public ModelAndView create(@ModelAttribute("dishTypeId") String dishTypeId, @ModelAttribute("member") String member,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		DishType parent = new DishType();
		parent.setDishTypeId(dishTypeId);

		try {
			dishTypeService.add(new DishType(dishTypeId, parent));
		}
		catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", redirectAttributes);
			modelAndView.setViewName("redirect:/Error");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/DishTypes/");
		return modelAndView;
	}

	@GetMapping("Edit/{dishTypeId}")
	public ModelAndView edit(@PathVariable("dishTypeId") String dishTypeId, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		DishType dishType = dishTypeService.getDishType(dishTypeId);

		if (dishType == null) {
			redirectAttributes.addFlashAttribute("errorView", new ErrorView(404, "Not Found",
					"The requested resource could not be found but may be available in the future."));
			modelAndView.setViewName("redirect:/Error");
			return modelAndView;
		}
		try {
			dishTypeService.edit(dishType);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@PostMapping("Edit")
	public ModelAndView edit(@ModelAttribute("dishType") DishType dishType, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			dishTypeService.edit(dishType);
		}
		catch (Exception e) {
			// redirectAttributes.addFlashAttribute("errorView", new ErrorView("","",""));
			modelAndView.setViewName("redirect:/Error");
			return modelAndView;
		}
		modelAndView.setViewName("/DishTypes/All");
		return modelAndView;
	}

}
