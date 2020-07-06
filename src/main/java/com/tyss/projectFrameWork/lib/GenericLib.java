package com.tyss.projectFrameWork.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;
import com.tyss.projectFrameWork.init.IConstants;

public class GenericLib
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
public static void clickElement(WebDriver driver,WebElement ele,String eleName)
{
	WebDriverWait wait=new WebDriverWait(driver,10);
	try {
	wait.until(ExpectedConditions.visibilityOf(ele)).click();
	Reporter.log("Clicked on "+ eleName);
	}
	catch(Exception e)
	{
		Reporter.log(eleName+" is not Displayed");
		Assert.fail();
	}
}
public static void enterText(WebDriver driver,WebElement ele,String text,String eleName)
{
	WebDriverWait wait=new WebDriverWait(driver,10);
	try
	{
	wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
	Reporter.log("Entered Text \" "+text+" \" in the"+eleName);
	}
	catch(Exception e)
	{
  Reporter.log(eleName+" is not Displayed");
  Assert.fail();
	}
}
public static void saveScreenShot(WebDriver driver, String name) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
	  String timeCurrent = LocalDateTime.now().format(dtf);
	  File src=ts.getScreenshotAs(OutputType.FILE);
	File desc=new File(IConstants.Screenshots+name+""+timeCurrent+"_Failed.png");
	try {
		Files.copy(src, desc);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
}
	
}

