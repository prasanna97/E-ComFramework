package com.tyss.projectFrameWork.lib;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base 
{
	public WebDriver driver;
	static {
		System.setProperty(GenericLib.getPropData("browserkey"),GenericLib.getPropData("broeservalue"));
		}
	
	@BeforeMethod
	public void setUp()
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
			
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(GenericLib.getPropData("url"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
