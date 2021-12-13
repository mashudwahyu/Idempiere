package com.bajra.testplugin;


import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

public class MyProcessFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		
		if(className.equals("com.bajra.process.MyProcess"))
			return new MyProcess();
		return null;
	}

}