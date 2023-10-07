package com.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.base.baseClass;

public class utility extends baseClass{

	private static boolean isEnabled;
	
	public static void dropDown(WebElement ele, String value) {
		Select stl = new Select(ele);
		stl.selectByValue(value);	
	}
	public static void actions(WebElement ele) {
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
}
	public static void scrolldown(WebElement ele) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
	
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	}
	
	public static void explicitWait(WebElement element, Duration i ) {
		WebDriverWait wait = new WebDriverWait(driver,i);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void ElementUtility() {
        // Initialize isEnabled to false by default
        isEnabled = false;
    }

	public static boolean isEnabled(WebElement element ) {
		isEnabled = element.isEnabled();
        return isEnabled;
	}
	
	
}
