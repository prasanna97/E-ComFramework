package com.tyss.frameworkscripts;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.projectFrameWork.init.BaseLib;
import com.tyss.projectFrameWork.init.IConstants;
import com.tyss.projectFrameWork.lib.ExcelLib;
import com.tyss.projectFrameWork.pages.HomePage;
import com.tyss.projectFrameWork.pages.MyCartPage;
import com.tyss.projectFrameWork.pages.SignInpage;

public class LoginTest1 extends BaseLib
{

@Test
public void TC_01() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	FileInputStream fin=new FileInputStream(IConstants.dataExcelPath);
	Workbook wb = WorkbookFactory.create(fin);
	Sheet sh = wb.getSheet("Sheet1");
	String username = sh.getRow(1).getCell(1).getStringCellValue();
	String password = sh.getRow(1).getCell(2).getStringCellValue();
	driver.findElement(By.name("email")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	Thread.sleep(2000);
	driver.findElement(By.name("login")).click();
	Thread.sleep(2000);
	
	}
@Test
public void TC_02()
{
	HomePage hp=new HomePage(driver);
	hp.myAccountBtnClick();
	SignInpage sip=new SignInpage(driver);
	String un=ExcelLib.getdata("Sheet1",1,1,IConstants.dataExcelPath);
	String pwd=ExcelLib.getdata("Sheet1", 1,2,IConstants.dataExcelPath);
	sip.doLogin(un, pwd);
}
@Test
public void TC_03() throws InterruptedException  
{
	HomePage hp=new HomePage(driver);
	hp.SearchBoxEnterTextAndClick("TV");
	Thread.sleep(5000);
}
@Test
public void TC_04() throws InterruptedException
{
	
	SignInpage sip=new SignInpage(driver);
	Assert.assertEquals(sip.getSignInPage(),ExcelLib.getdata("Sheet1", 1, 2,IConstants.expectedExceldata));
	String un=ExcelLib.getdata("Sheet1", 1, 1,IConstants.dataExcelPath);
	String pwd=ExcelLib.getdata("Sheet1", 1, 2, IConstants.dataExcelPath);
	sip.doLogin(un, pwd);
	HomePage hp=new HomePage(driver);
	Assert.assertEquals(hp.getHomePageTitle(),ExcelLib.getdata("Sheet1", 1, 1,IConstants.expectedExceldata));
	hp.myAccountBtnClick();
	MyCartPage mcp=new MyCartPage(driver);
	Assert.assertTrue(mcp.getWelcomeName().contains(ExcelLib.getdata("Sheet1", 1, 3,IConstants.expectedExceldata)));
	Thread.sleep(2000);
	

}

}
