package com.nutrition.information.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.nutrition.information.entities.Unit;
import com.nutrition.information.helper.TransactionResult;
import com.nutrition.information.persistence.UnitDao;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UnitServiceImpl  implements UnitService {

	@Autowired
	private UnitDao unitDao;
	
	@Override
	public Unit getUnit(String unitId) {
		
		return unitDao.getUnit(unitId);
	}

	@Override
	public List<Unit> getAllUnits() {
	
		return unitDao.getAllUnits();
	}

	@Override
	public TransactionResult add(Unit unit) {
		
		int result = unitDao.insert(unit.getUnitId(),unit.getToGram());
		
		if (result > 0) {
			
			return TransactionResult.SUCCEED;
		}
		return TransactionResult.FAILD;
	}

	@Override
	public TransactionResult edit(Unit unit) {
		
		int result = unitDao.update(unit.getUnitId(),unit.getToGram());
		
		if (result > 0) {
			
			return TransactionResult.SUCCEED;
		}
		return TransactionResult.FAILD;
	}

	@Override
	public TransactionResult remove(String unitId) {
		int result = unitDao.delete(unitId);
		if (result > 0) {
			
			return TransactionResult.SUCCEED;
		}
		return TransactionResult.FAILD;
	}

}
