package com.bajra.testplugin;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

public class GenerateNameFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		
		if(className.equals("com.bajra.testplugin.GenerateName"))
			return new GenerateName();
		return null;
	}

}
