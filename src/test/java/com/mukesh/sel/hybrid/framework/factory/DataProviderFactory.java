package com.mukesh.sel.hybrid.framework.factory;

import com.mukesh.sel.hybrid.framework.dataprovider.ConfigDataProvider;
import com.mukesh.sel.hybrid.framework.dataprovider.ExcelDataProvider;

public class DataProviderFactory {
	
	
	public static ConfigDataProvider getConfigDataProvider() {
		
		ConfigDataProvider config = new ConfigDataProvider();
		
		return config;
	}
	
	public static ExcelDataProvider getExcelDataProvider() {
		
		ExcelDataProvider excel = new ExcelDataProvider();
		
		return excel;
	}

}
