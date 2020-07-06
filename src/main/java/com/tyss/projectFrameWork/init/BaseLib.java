package com.tyss.projectFrameWork.init;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tyss.projectFrameWork.lib.GenericLib;

public class BaseLib 
{
	public WebDriver driver;
	static {
		System.setProperty(GenericLib.getPropData("browserkey"),GenericLib.getPropData("browservalue"));
		}
	
	@BeforeMethod
	public void setUp(ITestContext context)
	{
		if(GenericLib.getPropData("browsername").equalsIgnoreCase("chrome")) 
		{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		}
		else if(GenericLib.getPropData("browsername").equalsIgnoreCase("Firefox")){
	FirefoxOptions options=new FirefoxOptions();
	options.addPreference("dom.webnotifications.enabled", false);
	driver=new FirefoxDriver(options);
		}
		else
		{
			Assert.fail("BrowserName not found");
		}
			
		context.setAttribute("driver", driver);
		Reporter.log("Browser Launched Sucessfully");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(GenericLib.getPropData("url"));
	Reporter.log("Application closed");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
