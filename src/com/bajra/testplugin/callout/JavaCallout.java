package com.bajra.testplugin.callout;

import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;

public class JavaCallout extends CalloutEngine{
	public String javaCalloutMethod (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		System.out.println(WindowNo +" - "+mTab+" - "+mField+" - "+ value);
		return null;
	}
	

}
