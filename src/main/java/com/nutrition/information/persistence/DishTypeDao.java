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
	
	@Query("from DishType")
	public List<DishType> getAllDishTypes();
	
	@Query("from DishType where DishTypeId = :dishTypeId")
	public DishType getDishType(@Param("dishTypeId") String dishTypeId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into DishType (dishTypeId,member)values(:dishTypeId,:member)",nativeQuery = true)
	public int insert(@Param("dishTypeId")String dishTypeId, @Param("member")String member);
	
	@Transactional
	@Modifying
	@Query(value="update DishType set member = :member where dishTypeId = :dishTypeId", nativeQuery = true)
	public int update(@Param("dishTypeId") String dishTypeId,@Param("member") String member);  
	
	@Transactional
	@Modifying
	@Query(value = "delete from DishType where dishTypeId = :dishTypeId", nativeQuery = true)
	public int delete(@Param("dishTypeId") String dishTypeId);

}
