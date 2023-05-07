package com.nutrition.information.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrition.information.entities.Warning;
import com.nutrition.information.persistence.WarningDao;

@Service
public class WarningServiceImp implements WarningService {

	@Autowired
	private WarningDao warningDao;
	@Override
	public List<Warning> getAll() {
		return warningDao.findAll();
	}

	@Override
	public Warning getWarning(String warningId)  {
		
		 Optional<Warning> warning = warningDao.findById(warningId);
		 if (warning.isEmpty()) {
			 return null;
		 }
		 return warning.get();
	}

	@Override
	public int add(Warning warning) throws SQLException {
		int result =0;
		if (warning != null ) {
			result = warningDao.insert(warning.getWarningId(),warning.getWarningType(), warning.getMessage());
		}	
		return result;
	}

	@Override
	public int edit(Warning warning) throws SQLException{
		int result = warningDao.update(warning.getWarningId(),warning.getWarningType(),warning.getMessage());
		return result;
		
	}

	@Override
	public int remove(String warningId) {
		int result = warningDao.delete(warningId);
		return result;
		
		
	}

}
