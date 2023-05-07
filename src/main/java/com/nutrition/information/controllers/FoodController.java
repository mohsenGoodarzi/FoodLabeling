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

import com.nutrition.information.entities.ErrorView;
import com.nutrition.information.entities.Food;
import com.nutrition.information.helper.HttpHelper;
import com.nutrition.information.services.FoodService;

@RequestMapping("/Foods")
@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	@Autowired
	private HttpHelper httpHelper;

	@GetMapping("/All")
	public List<Food> all(){
		return foodService.all();
	}
	@GetMapping("Create")
	public ModelAndView create() {
		List <Food> foods = foodService.all();
		return new ModelAndView("/Foods/all.html","foods",foods);
	}
	
	@PostMapping("Create")
	public ModelAndView create (@ModelAttribute Food food, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			foodService.add(food);
		}catch (Exception e) {
			return httpHelper.redirect(new ErrorView(501,"Could not add new food","Try again later or contact support team."), modelAndView, redirectAttributes);
		}
		modelAndView.setViewName("redirect:Foods/All");
		return modelAndView;
	}
	@GetMapping("Edit/{foodId}")
	public ModelAndView edit(@PathVariable String foodId, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		Food food = foodService.getFood(foodId);
		if (food == null) {
		return	httpHelper.redirect(new ErrorView(501, "The food cannot be edited", "try again later") , modelAndView, redirectAttributes);
		}
		modelAndView.setViewName("/Foods/edit.html");
		modelAndView.addObject("food",food);
		return modelAndView;
	}
	@PostMapping("Edit")
	public ModelAndView edit(@ModelAttribute("food") Food food, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			foodService.edit(food);
		} catch (Exception e) {
			return	httpHelper.redirect(new ErrorView(501, "The food cannot be edited", "try again later") , modelAndView, redirectAttributes);
		}
		
		modelAndView.setViewName("redirect:Foods/All");
		return modelAndView;
	}
	@GetMapping("Delete/{foodId}")
	public ModelAndView delete(@PathVariable("foodId") String foodId, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		Food food = foodService.getFood(foodId);
		if (food == null) {
			return httpHelper.redirect(new ErrorView(403,"Not Found", "The food was not found."), modelAndView, redirectAttributes);
		}
		modelAndView.addObject("food",food);
		modelAndView.setViewName("/Foods/delete.html");
		return modelAndView;
	}
	@GetMapping("Delete")
	public ModelAndView deleteConfirmed(@ModelAttribute("foodId") String foodId, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			foodService.remove(foodId);
		} catch (Exception e) {
			return httpHelper.redirect(new ErrorView(403,"Not Found", "The food was not found."), modelAndView, redirectAttributes);
		}
		//modelAndView.addObject("food",food);
		modelAndView.setViewName("rediirect:/Foods/All");
		return modelAndView;
	}
}
