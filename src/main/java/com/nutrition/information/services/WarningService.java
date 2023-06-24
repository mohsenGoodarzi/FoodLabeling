package com.nutrition.information.services;

import java.sql.SQLException;
import java.util.List;
import com.nutrition.information.entities.Warning;

public interface WarningService {

	public List<Warning> getAll();

	public Warning getWarning(String warningId);

	public int add(Warning warning) throws SQLException;

	public int edit(Warning warning) throws SQLException;

	public int remove(String warningId);

}
