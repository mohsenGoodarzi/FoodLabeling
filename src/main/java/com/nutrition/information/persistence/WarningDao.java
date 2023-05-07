package com.nutrition.information.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nutrition.information.entities.Warning;

@Repository
public interface WarningDao extends JpaRepository<Warning, String> {
	
	
	@Query(value = "from warning where warning_id = :warningId",nativeQuery = true)
	public Warning getWarning(String warningId);
	
	@Query(value="from warning", nativeQuery = true)
	public List<Warning> getAllWarnings();
	
	@Transactional
	@Modifying
	@Query(value="Insert into warning(warning_id,warning_type, message) values(:warningId, :warningType, :message)",nativeQuery=true )
	public int insert(@Param("warningId")String warningId,@Param("warningType") String warningType,@Param("message") String message); 
	

	@Transactional
	@Modifying
	@Query(value="update warning set warning_type = :warningType, message = :message where warning_id= :warningId",nativeQuery=true )
	public int update(@Param("warningId")String warningId,@Param("warningType") String warningType,@Param("message") String message); 


	@Transactional
	@Modifying
	@Query(value="delete from warning where warning_id = :warningId",nativeQuery=true )
	public int delete(@Param("warningId")String warningId); 

}
