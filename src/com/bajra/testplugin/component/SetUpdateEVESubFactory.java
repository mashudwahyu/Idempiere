package com.bajra.testplugin.component;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import com.bajra.testplugin.process.SetUpdateEVESub;

public class SetUpdateEVESubFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		if(className.equals("com.bajra.testplugin.process.SetUpdateEVESub"))
			return new SetUpdateEVESub();
		return null;
	}

}
