package com.nutrition.information.services;
import java.util.List;

import com.nutrition.information.entities.Unit;
import com.nutrition.information.helper.TransactionResult;

public interface UnitService {

	public Unit getUnit(String unitId);
	public List<Unit> getAllUnits();
	public TransactionResult add(Unit unit);
	public TransactionResult edit(Unit unit);
	public TransactionResult remove(String unitId);
	
}
