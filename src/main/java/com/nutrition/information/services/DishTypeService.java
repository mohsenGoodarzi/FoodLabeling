package com.nutrition.information.services;

import java.util.List;

import com.nutrition.information.entities.DishType;

public interface DishTypeService {
	public List<DishType> all();
	public DishType getDishType(String dishType);
	public void add(DishType dishType) throws Exception;
	public void edit(DishType dishType) throws Exception;
	public void remove(DishType dishType) throws Exception;
	
}
