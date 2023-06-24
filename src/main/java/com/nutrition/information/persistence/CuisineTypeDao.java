/**
 *
 */
package com.nutrition.information.persistence;

import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nutrition.information.entities.CuisineType;

@Persistent
public interface CuisineTypeDao extends JpaRepository<CuisineType, String> {

	@Query(value = "from CuisineType")
	public List<CuisineType> getAllCuisineTypes();

	@Query(value = "from CuisineType where cuisineTypeId = :cuisineTypeId")
	public CuisineType getCuisineType(@Param("cuisineTypeId") String cuisineTypeId);

	@Transactional
	@Modifying
	@Query(value = "insert into CuisineType(cuisineTypeId,member)values(:cuisineTypeId,:member)", nativeQuery = true)
	// member has to be String in insert operation
	public int insert(@Param("cuisineTypeId") String cuisineTypeId, @Param("member") String member);

	@Transactional
	@Modifying
	@Query(value = "update CuisineType set member = :member where cuisineTypeId = :cuisineTypeId")
	public int update(@Param("cuisineTypeId") String cuisineTypeId, @Param("member") CuisineType member);

	@Transactional
	@Modifying
	@Query(value = "delete from CuisineType where cuisineTypeId = :cuisineTypeId", nativeQuery = true)
	public int delete(@Param("cuisineTypeId") String cuisineTypeId);

}
