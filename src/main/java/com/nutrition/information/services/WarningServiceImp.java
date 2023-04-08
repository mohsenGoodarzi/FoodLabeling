package com.nutrition.information.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrition.information.entities.Warning;
import com.nutrition.information.helper.NotFoundException;
import com.nutrition.information.helper.TransactionResult;
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
	public Warning getWarning(String warningId) throws NotFoundException {
		
		 Optional<Warning> warning = warningDao.findById(warningId);
		 if (warning.isEmpty()) {
			 throw new NotFoundException("not found");
		 }
		 return warning.get();
	}

	@Override
	public TransactionResult add(Warning warning) {
		if (warning != null ) {
			
			int result = warningDao.insert(warning.getWarningId(),warning.getWarningType(), warning.getMessage());
			
			if (result >0 ) {
				
				return TransactionResult.SUCCEED; 
			}
		}
		
		return TransactionResult.FAILD;
		
	}

	@Override
	public TransactionResult edit(Warning warning) {
		int result = warningDao.update(warning.getWarningId(),warning.getWarningType(),warning.getMessage());
		if (result>0) {
			
			return TransactionResult.SUCCEED;
		}
		return TransactionResult.FAILD;
	}

	@Override
	public TransactionResult remove(String warningId) {
		int result = warningDao.delete(warningId);
		
		if (result >0 ) {
			
			return TransactionResult.SUCCEED;
		}
		return TransactionResult.FAILD;
	}

}
