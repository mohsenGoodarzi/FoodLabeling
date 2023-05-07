package com.nutrition.information.persistence;

import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nutrition.information.entities.DishType;


@Persistent
public interface DishTypeDao extends JpaRepository<DishType,String>{
	
	@Query(value="from dish_type",nativeQuery = true)
	public List<DishType> getAllDishTypes();
	
	@Query(value="from dish_type where dish_type_id = :dish_type_id",nativeQuery = true)
	public DishType getDishType(@Param("dish_type_id") String dishTypeId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into dish_type (dish_type_id,member)values(:dishTypeId,:member)",nativeQuery = true)
	public int insert(@Param("dishTypeId")String dishTypeId, @Param("member")String member);
	
	@Transactional
	@Modifying
	@Query(value="update dish_type set member = :member where dish_type_id = :dishTypeId", nativeQuery = true)
	public int update(@Param("dishTypeId") String dishTypeId,@Param("member") String member);  
	
	@Transactional
	@Modifying
	@Query(value = "delete from dish_type where dish_type_id = :dishTypeId", nativeQuery = true)
	public int delete(@Param("dishTypeId") String dishTypeId);

}
