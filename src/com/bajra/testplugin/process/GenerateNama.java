package com.bajra.testplugin.process;


import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

public class GenerateNama extends SvrProcess{

	private String firstName;
	private String lastName;
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
			else if(name.equalsIgnoreCase("FirstName"))
				firstName = (String) para[i].getParameter();
			else if(name.equalsIgnoreCase("LastName"))
				lastName = (String) para[i].getParameter();
			else
				log.severe("Unknown Parameter : " + name);
		}
		log.info("Process Prepare with " + m_product_id + " " + firstName + " " + lastName);
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		addLog("Input String");
		addLog(getProcessInfo().getAD_Process_ID(),
				new Timestamp(System.currentTimeMillis()),
				new BigDecimal(getProcessInfo().getAD_PInstance_ID()),
				"The Input String was: "+ firstName + " " +lastName);
		
		return null;
	}

}
