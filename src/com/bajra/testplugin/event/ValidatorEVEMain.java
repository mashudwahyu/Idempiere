package com.bajra.testplugin.event;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.I_M_Product;
import org.compiere.model.PO;
import org.osgi.service.event.Event;

public class ValidatorEVEMain  extends AbstractEventHandler{

	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub
		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			PO po = getPO(event);
			System.out.println(" topic = "+ event.getTopic()+" po = "+po);
			if (po.get_TableName().equals(I_M_Product.Table_Name)) {
//				throw new RuntimeException("Data Tidak Sama, tidak dapat menyimpan!");
				
			}
		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_M_Product.Table_Name);
	}

}
