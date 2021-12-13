package com.bajra.testplugin.callout;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MProduct;


public class CalloutFactory  implements IColumnCalloutFactory  {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		// TODO Auto-generated method stub
		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		
		if(tableName.equals(MProduct.Table_Name) && columnName.equals(MProduct.COLUMNNAME_Help))
			list.add(new CalloutFromFactory());
		
		return list != null ? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}


}
