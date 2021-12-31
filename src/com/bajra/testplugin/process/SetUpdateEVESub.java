package com.bajra.testplugin.process;


import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;


import com.bajra.testplugin.model.MEVEMain;
import com.bajra.testplugin.model.MEVESub;

public class SetUpdateEVESub extends SvrProcess{
	
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
			else
				log.severe("Unknown Parameter : " + name);
		}
		log.info("Process Prepare with " + eve_main_id);
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		
		MEVEMain main = new MEVEMain(getCtx(), eve_main_id, get_TrxName());
		MEVESub[] lines = main.getLines();
		
		for(MEVESub line : lines){
				if(lines==null) {
					return "Eve Main doesnt have line";
				}else{
					value=line.getValue();
					nama=line.getName();
					line.setValue(value+" Updated"); 
					line.setName(nama+" Updated");
					line.setEVE_Main_ID(eve_main_id);
					line.saveEx();
					addLog("Berhasil!! Silahkan cek EVE Main");
				}
		}
		
		return "Eve Main doesnt have line";
	}

}
