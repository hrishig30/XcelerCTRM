package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.baseClass;
import com.utility.utility;

public class loginPagePom extends baseClass{
	
	public loginPagePom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//*[text()='Login to Xceler.ai']")
	WebElement login;
	
	@FindBy(xpath ="//*[@placeholder='Company']")
	WebElement companyname;
	
	@FindBy(xpath="//*[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//*[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//*[text()='LOGIN']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Yes']")
	WebElement loginMsg;
	
	
	
	public void loginOperation() throws InterruptedException {
		
		
		
		login.click();
		Thread.sleep(3000);
		companyname.sendKeys("manu");
		Thread.sleep(3000);
		Reporter.log("Company entered: "+companyname.getAttribute("value"));
		
		
		username.sendKeys("Hrishikesh");
		Reporter.log("Username entered: "+username.getAttribute("value"));
		
		password.sendKeys("Hrishikesh@1234");
		Reporter.log("Password entered: "+ password.getAttribute("value"));
		
		Thread.sleep(3000);
	
	}
	public String tohomepage() throws InterruptedException {
		loginButton.click();
		loginMsg.click();
		Reporter.log("Logged In");
		Thread.sleep(3000);
		
		
		String title=driver.getTitle();
		return title;
	}
}
