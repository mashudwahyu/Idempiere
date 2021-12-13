package com.bajra.testplugin.process;


import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

public class GenerateNamaFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		
		if(className.equals("com.bajra.testplugin.process.GenerateNama"))
			return new GenerateNama();
		return null;
	}

}
