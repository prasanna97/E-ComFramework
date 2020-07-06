package com.tyss.projectFrameWork.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tyss.projectFrameWork.init.IConstants;

public class GeneriLib
{
public static String getPropData(String key)
{
	String data="";
	try {
		FileInputStream fin=new FileInputStream(IConstants.propFilePath);
		Properties prop=new Properties();
		prop.load(fin);
		data=prop.getProperty(key);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return data;
	
}
}
