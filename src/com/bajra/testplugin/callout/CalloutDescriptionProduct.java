package com.bajra.testplugin.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;

public class CalloutDescriptionProduct implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		mTab.setValue("description",value);
		System.out.println(ctx+" - "+ WindowNo +" - "+mTab +" - " + mField +" - " + value +" - " + oldValue);
		return null;
	}

}
