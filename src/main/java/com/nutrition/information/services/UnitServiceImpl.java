package com.nutrition.information.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.nutrition.information.entities.Unit;
import com.nutrition.information.persistence.UnitDao;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UnitServiceImpl implements UnitService {

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
	public int add(Unit unit) throws Exception {
		return unitDao.insert(unit.getUnitId(), unit.getToGram());
	}

	@Override
	public int edit(Unit unit) throws Exception {

		int result = unitDao.update(unit.getUnitId(), unit.getToGram());
		return result;

	}

	@Override
	public int remove(String unitId) throws Exception {
		int result = unitDao.delete(unitId);
		return result;
	}

}
