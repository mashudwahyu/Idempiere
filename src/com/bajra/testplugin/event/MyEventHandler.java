package com.bajra.testplugin.event;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.compiere.model.I_C_BP_Group;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_M_Product_Category;
import org.compiere.model.PO;
import org.osgi.service.event.Event;

public class MyEventHandler extends AbstractEventHandler{

	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub
		if (event.getTopic().equals(IEventTopics.AFTER_LOGIN)) {
			LoginEventData eventData = getEventData(event);
			System.out.println(" topic = "+event.getTopic()+" AD_Client_ID = "+eventData.getAD_Client_ID()+" AD_Org_ID = "
			+eventData.getAD_Org_ID()+"AD_Role_ID = "+eventData.getAD_Role_ID()+" AD_User_ID= "+eventData.getAD_User_ID());
		}else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			PO po = getPO(event);
			System.out.println(" topic = "+ event.getTopic()+" po= "+po);
		}else if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			PO po = getPO(event);
			System.out.println(" topic = "+ event.getTopic()+" po= "+po);
			if (po.get_TableName().equals(I_C_BP_Group.Table_Name)) {
				throw new RuntimeException("No new business partner group for now");
			}
		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		registerEvent(IEventTopics.AFTER_LOGIN);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_C_Order.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_C_BP_Group.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_M_Product_Category.Table_Name);
		
	}

}
