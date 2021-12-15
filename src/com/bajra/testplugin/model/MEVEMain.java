package com.bajra.testplugin.model;

import java.sql.ResultSet;
import java.util.Properties;

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

	
		
}
