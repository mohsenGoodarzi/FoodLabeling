package com.nutrition.information.services;

import java.util.List;

import com.nutrition.information.entities.CuisineType;

public interface CuisineTypeService {
	public CuisineType getCuisineType(String cuisineTypeId);
	public List<CuisineType> getAllCuisineTypes();
	public int add(CuisineType cuisineType) throws Exception;
	public int edit(CuisineType cuisineType) throws Exception;
	public int remove(String cuisineTypeId) throws Exception;
}
