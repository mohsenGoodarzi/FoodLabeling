package com.nutrition.information.services;

import java.util.List;
import com.nutrition.information.entities.Unit;

public interface UnitService {

	public Unit getUnit(String unitId);

	public List<Unit> getAllUnits();

	public int add(Unit unit) throws Exception;

	public int edit(Unit unit) throws Exception;

	public int remove(String unitId) throws Exception;

}
