package com.tyss.frameworkscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.projectFrameWork.init.BaseLib;
import com.tyss.projectFrameWork.init.IConstants;
import com.tyss.projectFrameWork.lib.ExcelLib;
import com.tyss.projectFrameWork.pages.HomePage;
import com.tyss.projectFrameWork.pages.MyCartPage;
import com.tyss.projectFrameWork.pages.SignInpage;

public class LoginTest extends BaseLib
{
@Test
public void TC_01() throws InterruptedException
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
