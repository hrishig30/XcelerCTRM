package com.pom;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.baseClass;
import com.utility.ExcelSheethandle;
import com.utility.utility;

public class trade extends baseClass{
	
	public trade() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='table-content']")
	WebElement tableContent;
	
	
	@FindBy(xpath="//*[text()='Add']")
	WebElement add;
	
	@FindBy(xpath="//*[@placeholder='Enter Trade Date']")
	WebElement tradeDate;
	
	@FindBy(xpath="//span[text()='Company ']/following-sibling::tui-select/div/select")
	WebElement companyName;
	
	@FindBy(xpath="//span[text()='Company ']/following-sibling::tui-select/div/select/option")
	List<WebElement> listcompanyName;
	
	@FindBy(id="SELL")
	WebElement buy_sell;
	
	@FindBy(xpath="//span[text()='Counterparty Code ']/following-sibling::tui-select/div/select")
	WebElement counterpartyCode;
	
	@FindBy(xpath="//span[text()='Profit Center ']/following-sibling::tui-select/div/select")
	WebElement profitCenter;
	
	@FindBy(xpath="//span[text()='Trader Name ']/following-sibling::tui-select/div/select")
	WebElement traderName;
	
	@FindBy(xpath="//span[text()='Commodity ']/following-sibling::tui-select/div/select")
	WebElement Commodity;
	
	@FindBy(xpath="//span[text()='Quality Terms Clause ']/following-sibling::tui-input-with-select/div//input")
	WebElement qualityTermsClause;

	
	@FindBy(xpath="//span[text()='Incoterm ']/following-sibling::tui-select/div/select")
	WebElement incoterm ;
	
	@FindBy(xpath="//span[text()='Load Location ']/following-sibling::tui-multi-select/div/div")
	WebElement loadLocation;
	
	@FindBy(xpath="//span[text()='Unload Location ']/following-sibling::tui-multi-select/div/div")
	WebElement unloadLocation;
	
	@FindBy(xpath="//span[text()='Quantity Uom ']/following-sibling::tui-select/div/select")
	WebElement quantityUom;
	
	@FindBy(xpath="//*[@placeholder='Enter Quantity/Period']")
	WebElement quantity_Period;
	
	@FindBy(xpath="//*[@placeholder='Enter Period Start Date']")
	WebElement periodStartDate;
	
	@FindBy(xpath="//*[@placeholder='Enter Period End Date']")
	WebElement periodEndDate;
	
	@FindBy(xpath="//*[text()='Percentage']")
	WebElement quantityToleranceType;
	
	@FindBy(xpath="//span[text()='Price Type ']/following-sibling::tui-select/div/select")
	WebElement priceType;
	
	
	@FindBy(xpath="//span[text()='Price ']/following-sibling::tui-input/div/input")
	WebElement price;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//*[text()='BUY']")
	List<WebElement> buy;
	int buycount=0;
	
	@FindBy(xpath="//*[text()='SELL']")
	List<WebElement> sell;
	int sellcount=0;
	
	@FindBy(xpath="//span[@class='viewChildPage']")
	List<WebElement> newTradeID;
	
	@FindBy(xpath="//span[text()='SELL'] | //span[text()='BUY']")
	List<WebElement> newBuyorSell;
	
	
	@FindBy(xpath="//span[contains(text(),'Total')]")
	List<WebElement> TotalTrades;
	
	
	
	public void tradePage() throws InterruptedException {
		
		//System.out.println(tableContent.getText());
		add.click();
		
		//utility.dropDown(companyName,value);
		
		Thread.sleep(3000);
		
	}
	public void companyname() throws InterruptedException {
	Thread.sleep(3000);
	Reporter.log("Moved to Home Page");
	Reporter.log("Page Title: "+driver.getTitle());
	
	if(!TotalTrades.isEmpty()) {
		Reporter.log("Total Trades before adding new: "+TotalTrades.get(0).getText());
	}
	
	 
	ExcelSheethandle excelData = new ExcelSheethandle();
	HashMap<String, Object> data = excelData.getExcelSheetData("book2", 1);
	Reporter.log("New Trade Creation Started");
	buy_sell.click();
	tradeDate.sendKeys(data.get("TradeDate")+"");
	
	companyName.click();
	utility.dropDown(companyName, data.get("username")+"");
	Thread.sleep(5000);
	
	utility.dropDown(counterpartyCode, data.get("CounterpartyCode")+"");
	Thread.sleep(5000);
	
	utility.dropDown(profitCenter, data.get("ProfitCenter")+"");
	
	utility.dropDown(traderName, data.get("TraderName")+"");
	//Thread.sleep(3000);
	//Commodity.click();
	System.out.println(data.get("Incoterm")+"");
	System.out.println(data.get("TraderName"));

	
	utility.scrolldown(Commodity);
	utility.dropDown(Commodity, data.get("commodity")+"");	
		utility.explicitWait(incoterm, Duration.ofSeconds(20));
		utility.scrolldown(incoterm);
		System.out.println(data.get("Incoterm"));
		utility.dropDown(incoterm, data.get("Incoterm")+"");
		utility.explicitWait(quantityUom, Duration.ofSeconds(20));
		utility.dropDown(quantityUom,data.get("QuantityUOM")+"");
		quantity_Period.sendKeys(data.get("Quantity_period")+"");
		utility.scrolldown(periodStartDate);
		
		periodStartDate.sendKeys(data.get("PeriodStartDate")+"");
		periodEndDate.sendKeys(data.get("PeriodEndDate")+"");
		
		utility.scrolldown(price);
		utility.dropDown(priceType,data.get("PriceType")+"");
		//price.sendKeys(data.get("Price")+"");
		
		saveButton.click();
		Reporter.log("New Trade Created");
	}

	public void countBuy() throws InterruptedException {
	Thread.sleep(3000);	
		for(WebElement listbuy:sell) {
		if(listbuy.getText().equalsIgnoreCase("SELL")) {
			sellcount++;
		}
		}
		System.out.println("Sell count: "+sellcount);
		Reporter.log("Sell count: "+sellcount);
	}
	public void countSell() {
		
		for(WebElement listbuy:buy) {
		if(listbuy.getText().equalsIgnoreCase("BUY")) {
			buycount++;
		}
		}
		System.out.println("Buy count: "+buycount);
		Reporter.log("Buy count: "+buycount);
	}
	
	public void printTrade() {
		
		//for(WebElement listTrades:newTrade) {
		//	int one=1;
			 if (!newTradeID.isEmpty()) {
				 Reporter.log("New trade data: "+newTradeID.get(0).getText());
			}
			 
			
			 if(!newBuyorSell.isEmpty()) {
				 Reporter.log("BUY or SELL: "+newBuyorSell.get(0).getText()); 
			 }
			 
			 if(!TotalTrades.isEmpty()) {
					Reporter.log("Total Trades After adding new: "+TotalTrades.get(0).getText());
				}
		}
		
	
}

	
