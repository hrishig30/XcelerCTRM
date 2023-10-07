package com.testCases;

import java.time.Duration;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.baseClass;
import com.pom.loginPagePom;

import com.pom.xcelerCTRM;

import com.pom.trade;

import com.utility.ExcelSheethandle;



public class loginTest extends baseClass{
	
	@BeforeMethod
	public void setUp() 
	{
		loadApplication();
		driver.get(prop.getProperty("baseurl"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
		
	} 
	
	@Test(priority=1)
	public  void login() throws InterruptedException 
	{
		
		loginPagePom loginPage = new loginPagePom();
		
		loginPage.loginOperation();
		loginPage.tohomepage();
		
		
		xcelerCTRM homepage =new xcelerCTRM();
		homepage.homepage();
	}
	
}
