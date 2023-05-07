/**
 * 
 */
package com.nutrition.information.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nutrition.information.entities.CuisineType;

/**
 * @author Mohsen Goodarzi
 *
 */
@Repository
public interface CuisineTypeDao extends JpaRepository<CuisineType, String>{
	
	
	
	@Query(value="from cuisine_type",nativeQuery = true)
	public List<CuisineType> getAllCuisineTypes();
	
	@Query(value="from cuisine_type where cuisine_type_id = :cuisineTypeId", nativeQuery = true)
	public CuisineType getCuisineType(@Param("cuisineTypeId") String cuisineTypeId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into cuisine_type (cuisine_type_id,member)values(:cuisineTypeId,:member)",nativeQuery = true)
	public int insert(@Param("cuisineTypeId")String cuisineTypeId, @Param("member")String member);
	
	@Transactional
	@Modifying
	@Query(value="update cuisine_type set member = :member where cuisine_type_id = :cuisineTypeId", nativeQuery = true)
	public int update(@Param("cuisineTypeId") String cuisineTypeId,@Param("member") CuisineType member);  
	
	@Transactional
	@Modifying
	@Query(value = "delete from cuisine_type where cuisine_type_id = :cuisineTypeId", nativeQuery = true)
	public int delete(@Param("cuisineTypeId") String cuisineTypeId);

}
