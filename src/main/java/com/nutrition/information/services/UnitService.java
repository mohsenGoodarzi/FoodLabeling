package com.nutrition.information.services;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.JDBCException;

import com.nutrition.information.entities.Unit;
import com.nutrition.information.helper.TransactionResult;

public interface UnitService {

	public Unit getUnit(String unitId);
	public List<Unit> getAllUnits();
	public void add(Unit unit)throws Exception;
	public TransactionResult edit(Unit unit)throws Exception;
	public TransactionResult remove(String unitId);
	
}
