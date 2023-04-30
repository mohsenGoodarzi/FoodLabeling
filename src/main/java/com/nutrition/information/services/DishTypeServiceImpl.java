package com.nutrition.information.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrition.information.entities.DishType;
import com.nutrition.information.persistence.DishTypeDao;

@Service
public class DishTypeServiceImpl implements DishTypeService {
	
	@Autowired 
	private DishTypeDao dishTypeDao;
	
	public List<DishType> all(){
		return dishTypeDao.getAllDishTypes();
	}
	
	public DishType getDishType(String dishType) {
		return dishTypeDao.getDishType(dishType);
	}
	
	public void add(DishType dishType) throws Exception{
		dishTypeDao.insert(dishType.getDishTypeId(), dishType.getMember().getDishTypeId());
	}
	
	public void edit(DishType dishType) throws Exception{
		dishTypeDao.update(dishType.getDishTypeId(), dishType.getMember().getDishTypeId());
	}
	
	public void remove(DishType dishType) throws Exception{
		dishTypeDao.delete(dishType.getDishTypeId()); 
	}
	

}
