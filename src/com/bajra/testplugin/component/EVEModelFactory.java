package com.bajra.testplugin.component;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

import com.bajra.testplugin.model.MEVEMain;
import com.bajra.testplugin.model.MEVESub;

public class EVEModelFactory implements IModelFactory{

	@Override
	public Class<?> getClass(String tableName) {
		if(tableName.equalsIgnoreCase(MEVESub.Table_Name))
			return MEVESub.class;
		
		if(tableName.equalsIgnoreCase(MEVEMain.Table_Name))
			return MEVEMain.class;
		
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if(tableName.equalsIgnoreCase(MEVESub.Table_Name))
			return new MEVESub(Env.getCtx(), Record_ID, trxName);
		
		if(tableName.equalsIgnoreCase(MEVEMain.Table_Name))
			return new MEVEMain(Env.getCtx(), Record_ID, trxName);
		
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if(tableName.equalsIgnoreCase(MEVESub.Table_Name))
			return new MEVESub(Env.getCtx(), rs, trxName);
		
		if(tableName.equalsIgnoreCase(MEVEMain.Table_Name))
			return new MEVEMain(Env.getCtx(), rs, trxName);
		
		return null;
	}
}