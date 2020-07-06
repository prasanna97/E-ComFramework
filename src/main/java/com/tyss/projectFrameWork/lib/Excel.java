package com.tyss.projectFrameWork.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tyss.projectFrameWork.init.IConstants;

public class Excel 
{
public static String redDataFromExcel() 
{
	String data="";
	FileInputStream fin;
	try {
		fin = new FileInputStream(IConstants.dataExcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet("sheet1");
		String username = sh.getRow(1).getCell(1).getStringCellValue();
		String password = sh.getRow(1).getCell(2).getStringCellValue();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return null;
	
}
public static String writeData()
{
	
	try {
		
		File f=new File("D:\\selenium\\projectFrameWork\\src\\test\\resources\\excel\\Book1.xlsx");
		FileOutputStream fos=new FileOutputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh=wb.createSheet();
		sh.createRow(2).createCell(1).setCellValue("admin");
		sh.createRow(2).createCell(2).setCellValue("Test@123");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return null;
	
}
}
