package com.bajra.testplugin.component;


import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import com.bajra.testplugin.process.GenerateNama;

public class GenerateNamaFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		
		if(className.equals("com.bajra.testplugin.process.GenerateNama"))
			return new GenerateNama();
		return null;
	}

}
