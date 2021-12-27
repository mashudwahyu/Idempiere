package com.bajra.testplugin.process;


import org.compiere.model.MProduct;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;


import com.bajra.testplugin.model.MEVEMain;
import com.bajra.testplugin.model.MEVESub;


public class SetParameter extends SvrProcess{
	
	private int qty=0;
	private int eve_main_id;
	private String value = "";
	private String nama = "";
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for(int i = 0; i < para.length; i++ ) {
			String name = para[i].getParameterName();
			if(para[i].getParameter() == null)
				;
			else if (name.equalsIgnoreCase("EVE_Main_ID")) 
				eve_main_id = para[i].getParameterAsInt();
			else if(name.equalsIgnoreCase("Qty"))
				qty = para[i].getParameterAsInt();
			else
				log.severe("Unknown Parameter : " + name);
		}
		log.info("Process Prepare with " + eve_main_id + " " + qty);
	}
	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		MEVEMain main = new MEVEMain(getCtx(), eve_main_id, get_TrxName());
		main.getM_Product_ID();
		MProduct product = new MProduct(getCtx(), main.getM_Product_ID(), null);
		value = product.getValue();
		nama = product.getName();
		for(int i=0;i<qty;i++) {
			MEVESub sub = new MEVESub(getCtx(), 0, get_TrxName());
			sub.setValue(value);
			sub.setName(nama);
			sub.setEVE_Main_ID(eve_main_id);
			sub.saveEx();	
		}
		addLog("Berhasil!! /n Silahkan cek table eve main");
		return null;
	}
}
