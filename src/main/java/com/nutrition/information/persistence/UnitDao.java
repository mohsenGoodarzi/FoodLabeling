package com.nutrition.information.persistence;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nutrition.information.entities.Unit;


@Persistent
public interface UnitDao extends JpaRepository<Unit, String> {
	
	
	@Query("from Unit")
	public List<Unit> getAllUnits();
	
	@Query("from Unit where unitId = :unitId")
	public Unit getUnit(@Param("unitId") String unitId);
	
	// Insert Statement need to be native and @Modyfing. Hence it returns integer or void 
	@Transactional
	@Modifying // Modifying only can return void or integer
	// nativeQuery=true means do not validate the query
	@Query(value = "insert into Unit (unitId,toGram) values ( :unitId , :toGram )", nativeQuery=true)
	public int insert (@Param("unitId")String unitId,@Param("toGram") double toGram );
	
	@Transactional
	@Modifying // Modifying only can return void or integer. Hence remove(String unitId) can return integer or void
	@Query("delete from Unit where unitId = :unitId") 
	public int delete(@Param("unitId")String unitId);
	
	@Transactional
	@Modifying
	@Query(value="update Unit set toGram = :toGram where unitId = :unitId")
	public int update(@Param("unitId")String UnitId, @Param("toGram") double toGram);  
}
