package com.ot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ot.driver.DriverManager;
import com.ot.enums.WaitStrategy;
import com.ot.factories.ExplicitWaitFactory;
import com.ot.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
		try {
			ExtentLogger.pass(elementName+" is clicked", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void sendKeys(By by, String keysToSend, WaitStrategy waitStrategy,String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(keysToSend);
		try {
			ExtentLogger.pass(keysToSend + " value is entered successfully in "+elementName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		String title = DriverManager.getDriver().getTitle();
		ExtentLogger.pass("Got the title of the page");
		return title;
	}

}
