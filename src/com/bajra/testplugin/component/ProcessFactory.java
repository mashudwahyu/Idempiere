package com.bajra.testplugin.component;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import com.bajra.testplugin.process.SetParameter;


public class ProcessFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		if(className.equals("com.bajra.testplugin.process.SetParameter"))
			return new SetParameter();
		return null;
	}

}
