package com.bajra.testplugin;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

public class MyProcess extends SvrProcess{
	
	private int someInteger;
	private String someString;
	private int m_product_id;
	@Override
	
	protected void prepare() {
		// TODO Auto-generated method stub
		
		ProcessInfoParameter[] para = getParameter();
		for(int i = 0; i < para.length; i++ ) {
			String name = para[i].getParameterName();
			if(para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("M_Product_ID")) 
				m_product_id = para[i].getParameterAsInt();
			else if(name.equalsIgnoreCase("SomeString"))
				someString = (String) para[i].getParameter();
			else if(name.equalsIgnoreCase("SomeInteger")) 
				someInteger = para[i].getParameterAsInt();
			else
				log.severe("Unknown Parameter : " + name);
		}
		log.info("Process Prepare with " + m_product_id + " " + someString + " " + someInteger);
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		addLog("Some Messege");
		addLog(getProcessInfo().getAD_Process_ID(),
				new Timestamp(System.currentTimeMillis()),
				new BigDecimal(getProcessInfo().getAD_PInstance_ID()),
				"The Input String was: "+someString);
		/*
		 * addLog(getProcessInfo().getAD_Process_ID(), new
		 * Timestamp(System.currentTimeMillis()), new
		 * BigDecimal(getProcessInfo().getAD_PInstance_ID()),
		 * "The Input Integer was: "+someInteger, MProduct.Table_ID, m_product_id);
		 */
		
		return null;
	}
	
}
