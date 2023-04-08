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
	
	
	
	@Query("from CuisineType")
	public List<CuisineType> getAllCuisineTypes();
	
	@Query("from CuisineType where cuisineTypeId = :cuisineTypeId")
	public CuisineType getCuisineType(@Param("cuisineTypeId") String cuisineTypeId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into CuisineType (cuisineTypeId,member)values(:cuisineTypeId,:member)",nativeQuery = true)
	public int insert(@Param("cuisineTypeId")String cuisineTypeId, @Param("member")String member);
	
	@Transactional
	@Modifying
	@Query(value="update CuisineType set member = :member where cuisineTypeId = :cuisineTypeId", nativeQuery = true)
	public int update(@Param("cuisineTypeId") String cuisineTypeId,@Param("member") CuisineType member);  
	
	@Transactional
	@Modifying
	@Query(value = "delete from CuisineType where cuisineTypeId = :cuisineTypeId", nativeQuery = true)
	public int delete(@Param("cuisineTypeId") String cuisineTypeId);

}
