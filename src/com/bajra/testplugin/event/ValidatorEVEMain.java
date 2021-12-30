package com.bajra.testplugin.event;

import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MProduct;
import org.osgi.service.event.Event;
import com.bajra.testplugin.model.X_EVE_Main;


public class ValidatorEVEMain{	
	private X_EVE_Main main = null;
	private Event event;
	private String Namemain;
	private String Nameproduct;
	
	public ValidatorEVEMain(X_EVE_Main po, Event event) {
		main = po;
		Namemain = main.getName();
		main.getM_Product_ID();
		MProduct product = new MProduct(main.getCtx(), main.getM_Product_ID(), main.get_TrxName());
		Nameproduct = product.getName();
		this.event = event;
		
	}
	
	
	public String run()
	{
		if(main!=null && event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			if(!Namemain.equals(Nameproduct)) {
				throw new RuntimeException("Data tidak sama, tidak dapat menyimpan");
			}
		}
		if(main!=null && event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			if(Namemain.equals(Nameproduct)==false) {
				throw new RuntimeException("Data tidak sama, tidak dapat menyimpan");
			}
		}
		
		return null;
	}
}



