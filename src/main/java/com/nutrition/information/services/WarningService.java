package com.nutrition.information.services;


import java.sql.SQLException;
import java.util.List;

import com.nutrition.information.entities.Warning;
import com.nutrition.information.helper.TransactionResult;

public interface WarningService {
	
	public List<Warning> getAll();
	public Warning getWarning(String warningId);
	public TransactionResult add(Warning warning)throws SQLException ;
	public TransactionResult edit(Warning warning)throws SQLException ;
	public TransactionResult remove(String warningId);
	

}
