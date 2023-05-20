package com.nutrition.information.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrition.information.entities.CuisineType;
import com.nutrition.information.persistence.CuisineTypeDao;

@Service
public class CuisineTypeServiceImpl implements CuisineTypeService {

	@Autowired
	private CuisineTypeDao cuisineTypeDao;

	public CuisineType getCuisineType(String cuisineTypeId) {

		return cuisineTypeDao.getCuisineType(cuisineTypeId);
	}

	public List<CuisineType> getAllCuisineTypes() {
		return cuisineTypeDao.getAllCuisineTypes();
	}

	public int add(CuisineType cuisineType) throws Exception {
		return cuisineTypeDao.insert(cuisineType.getCuisineTypeId(), cuisineType.getMember().getCuisineTypeId());
	}

	public int edit(CuisineType cuisineType) throws Exception {
		return cuisineTypeDao.update(cuisineType.getCuisineTypeId(), cuisineType.getMember());
	}

	public int remove(String cuisineTypeId) throws Exception {
		return cuisineTypeDao.delete(cuisineTypeId);
	}

}
