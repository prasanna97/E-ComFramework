package com.tyss.projectFrameWork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tyss.projectFrameWork.lib.GenericLib;
public class HomePage {
WebDriver driver;
@FindBy(xpath="//a[text()='My Account']")
private WebElement myAccountBtn;
@FindBy(name="product")
private WebElement searchBox;
@FindBy(name="search")
private WebElement searchBtn;
public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void myAccountBtnClick()
{
	GenericLib.clickElement(driver,myAccountBtn,"Account Button");
}
public void SearchBoxEnterTextAndClick(String searchText) throws InterruptedException 
{
	GenericLib.enterText(driver,searchBox, searchText,"Account Button");
	Thread.sleep(2000);
	GenericLib.clickElement(driver, searchBtn,"Search Btn");
}
public String getHomePageTitle() {
	
	return driver.getTitle();
}
}
