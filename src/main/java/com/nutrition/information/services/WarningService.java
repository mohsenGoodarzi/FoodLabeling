package com.nutrition.information.services;


import java.util.List;

import com.nutrition.information.entities.Warning;
import com.nutrition.information.helper.TransactionResult;

public interface WarningService {
	
	public List<Warning> getAll();
	public Warning getWarning(String warningId)throws Exception;
	public TransactionResult add(Warning warning);
	public TransactionResult edit(Warning warning);
	public TransactionResult remove(String warningId);
	

}
