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
	
	
	@Query(value = "from Warning where warningId = :warningId")
	public Warning getWarning(String warningId);
	
	@Query(value="from Warning")
	public List<Warning> getAllWarnings();
	
	@Transactional
	@Modifying
	@Query(value="Insert into Warning(warningId,warningType, message) values(:warningId, :warningType, :message)",nativeQuery=true )
	public int insert(@Param("warningId")String warningId,@Param("warningType") String warningType,@Param("message") String message); 
	

	@Transactional
	@Modifying
	@Query(value="update Warning set warningType = :warningType, message = :message where warningId= :warningId",nativeQuery=true )
	public int update(@Param("warningId")String warningId,@Param("warningType") String warningType,@Param("message") String message); 


	@Transactional
	@Modifying
	@Query(value="delete from Warning where warningId = :warningId",nativeQuery=true )
	public int delete(@Param("warningId")String warningId); 

}
