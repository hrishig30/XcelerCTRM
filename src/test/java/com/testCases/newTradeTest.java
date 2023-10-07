package com.testCases;

import org.testng.annotations.Test;

import com.base.baseClass;
import com.pom.trade;


@Test
public class newTradeTest  extends baseClass{

	public void newtrade() throws InterruptedException {
	trade tradepage=new trade();
	tradepage.tradePage();
	tradepage.companyname();
	tradepage.countBuy();
	tradepage.countSell();
	tradepage.printTrade();
	
	}
}
