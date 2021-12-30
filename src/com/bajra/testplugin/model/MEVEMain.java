package com.bajra.testplugin.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;


public class MEVEMain extends X_EVE_Main{

	private static final long serialVersionUID = -7124837675070240912L;

	public MEVEMain(Properties ctx, int EVE_Main_ID, String trxName) {
		super(ctx, EVE_Main_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MEVEMain(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

public MEVESub[] getLines(){
		
		List<MEVESub> list = new Query(getCtx(), MEVESub.Table_Name, COLUMNNAME_EVE_Main_ID+"=?", get_TrxName())
							.setParameters(getEVE_Main_ID())
							.setOnlyActiveRecords(true)
							.list();
		
		return list.toArray(new MEVESub[list.size()]);
	}
		
}
