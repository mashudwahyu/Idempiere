package com.bajra.testplugin.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MEVESub extends X_EVE_Sub{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2076611601274220946L;

	public MEVESub(Properties ctx, int EVE_Sub_ID, String trxName) {
		super(ctx, EVE_Sub_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MEVESub(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
}