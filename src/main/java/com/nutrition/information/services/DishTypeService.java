package com.nutrition.information.services;

import java.util.List;

import com.nutrition.information.entities.DishType;

public interface DishTypeService {
	public List<DishType> all();
	public DishType getDishType(String dishType);
	public int add(DishType dishType) throws Exception;
	public int edit(DishType dishType) throws Exception;
	public int remove(DishType dishType) throws Exception;
	
}
