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
	
	
	@Query(value="from unit",nativeQuery = true)
	public List<Unit> getAllUnits();
	
	@Query(value="from unit where unit_id = :unitId", nativeQuery = true)
	public Unit getUnit(@Param("unitId") String unitId);
	
	// Insert Statement need to be native and @Modyfing. Hence it returns integer or void 
	@Transactional
	@Modifying // Modifying only can return void or integer
	// nativeQuery=true means do not validate the query
	@Query(value = "insert into unit (unit_id,to_gram) values ( :unitId , :toGram )", nativeQuery=true)
	public int insert (@Param("unitId")String unitId,@Param("toGram") double toGram );
	
	@Transactional
	@Modifying // Modifying only can return void or integer. Hence remove(String unitId) can return integer or void
	@Query(value="delete from unit where unit_id = :unitId", nativeQuery = true) 
	public int delete(@Param("unitId")String unitId);
	
	@Transactional
	@Modifying
	@Query(value="update unit set to_gram = :toGram where unit_id = :unitId",nativeQuery = true)
	public int update(@Param("unitId")String UnitId, @Param("toGram") double toGram);  
}
