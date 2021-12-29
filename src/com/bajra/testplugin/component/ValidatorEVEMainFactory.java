package com.bajra.testplugin.component;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.osgi.service.event.Event;

import com.bajra.testplugin.event.ValidatorEVEMain;
import com.bajra.testplugin.model.MEVEMain;


public class ValidatorEVEMainFactory extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(ValidatorEVEMainFactory.class);
	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub
		String type = event.getTopic();
		String msg = "";
		if (type.equals(IEventTopics.AFTER_LOGIN)) {
			LoginEventData eventData = getEventData(event);
			log.info(" topic="+event.getTopic()+" AD_Client_ID="+eventData.getAD_Client_ID()
					+" AD_Org_ID="+eventData.getAD_Org_ID()+" AD_Role_ID="+eventData.getAD_Role_ID()
					+" AD_User_ID="+eventData.getAD_User_ID());
		}else {
			PO po = getPO(event);
			log.info("Bajra >> ValidatorEVEMain : topic="+event.getTopic()+" po="+po);
			
			if(po.get_TableName().equals(MEVEMain.Table_Name)){
				ValidatorEVEMain validator = new ValidatorEVEMain((MEVEMain) po, event);
				msg = validator.run();
			}
		}
		if (msg!=null && msg.length() > 0)
			logEvent(event, getPO(event), msg);
	}
	private void logEvent (Event event, PO po, String msg) {
		log.fine("EVENT MANAGER // "+event.getTopic()+" po="+po+" MESSAGE ="+msg);
		throw new AdempiereException(msg);
	}


	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MEVEMain.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MEVEMain.Table_Name);		
	}	
}
