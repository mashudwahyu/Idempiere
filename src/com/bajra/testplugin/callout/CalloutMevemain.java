package com.bajra.testplugin.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;

import com.bajra.testplugin.model.MEVEMain;



public class CalloutMevemain implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		
		if(mTab.getTableName().equals(MEVEMain.Table_Name)) {
			if(mField.getColumnName().equals(MEVEMain.COLUMNNAME_M_Product_ID))
				setProductDetail(ctx, WindowNo, mTab, mField, value, oldValue);
		}
		return null;
	}

	private void setProductDetail(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(value==null)
			return;
		
		int M_Product_ID = (Integer)value;
		if(M_Product_ID>0) {
			MProduct product = new MProduct(ctx, M_Product_ID, null);
			if(product.get_Value("value")!= null)
				mTab.setValue("Value", product.get_Value("Value"));
			if(product.get_Value("Name")!= null)
				mTab.setValue("Name", product.get_Value("Name"));
		}
		
	}
}
