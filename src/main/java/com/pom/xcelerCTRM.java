package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;
import com.utility.utility;

public class xcelerCTRM extends baseClass{
	
	public xcelerCTRM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Trade ']")
	WebElement trade;
	
	@FindBy(xpath="//*[@ ng-reflect-ng-class='menuli']")
	WebElement physicalTrade;
	
	public void homepage() throws InterruptedException {
		utility.actions(trade);
		physicalTrade.click();
		Thread.sleep(3000);
	}
	
	public trade tradepage() {
		
		return new trade();
		
	}
}
