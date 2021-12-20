package com.bajra.testplugin.component;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MProduct;

import com.bajra.testplugin.callout.CalloutTest2;



public class Callouttest2Factory implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		// TODO Auto-generated method stub
		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		
		if(tableName.equals(MProduct.Table_Name) && columnName.equals(MProduct.COLUMNNAME_M_Product_ID))
			list.add(new CalloutTest2());
		
		
		return list != null ? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}

	

}
