package com.tyss.projectFrameWork.listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.tyss.projectFrameWork.lib.GenericLib;

public class MyListeners implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		  String starttime = LocalDateTime.now().format(dtf);
		Reporter.log("The Test Case " + result.getName() +" Started At :"+starttime);
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		  String endtime = LocalDateTime.now().format(dtf);
		  Reporter.log("The Test Case:" + result.getName() +" Completed At :" +endtime);
		  
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		  String endtime = LocalDateTime.now().format(dtf);
		  Reporter.log("The Test Case:" + result.getTestName() +" Failed At :"+endtime);
		  WebDriver driver=(WebDriver)result.getTestContext().getAttribute("driver");
		  GenericLib.saveScreenShot(driver,result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		  String starttime = LocalDateTime.now().format(dtf);
		  Reporter.log("The Test Suit Started At :"+starttime);
		  
		
	}

	@Override
	public void onFinish(ITestContext context) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		  String onfinishtime = LocalDateTime.now().format(dtf);
		  Reporter.log("The Test Suite Completed At:"+onfinishtime);
		  
		
	}

}
