package com.bajra.testplugin.process;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import com.bajra.testplugin.model.MEVEMain;

public class SetParameter extends SvrProcess{
	
	private int qty;
	private int EVE_Main_ID;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for(int i = 0; i < para.length; i++ ) {
			String name = para[i].getParameterName();
			if(para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("EVE_Main_ID")) 
				EVE_Main_ID = para[i].getParameterAsInt();
			else if(name.equalsIgnoreCase("qty"))
				qty = para[i].getParameterAsInt();
			else
				log.severe("Unknown Parameter : " + name);
		}
		log.info("Process Prepare with " + EVE_Main_ID + " " + qty);
	}
	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
