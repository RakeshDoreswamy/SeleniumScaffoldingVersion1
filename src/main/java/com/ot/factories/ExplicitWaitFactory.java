package com.ot.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ot.constants.FrameworkConstants;
import com.ot.driver.DriverManager;
import com.ot.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {};

	public static WebElement performExplicitWait(WaitStrategy waitStrategy , By by) {
		
		WebElement element = null;

		if(waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicittimeout())
			.until(ExpectedConditions.elementToBeClickable(by));
		} 
		else if (waitStrategy == WaitStrategy.PRESENCE) 
		{
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicittimeout())
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if (waitStrategy == WaitStrategy.VISIBILITY) 
		{
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicittimeout())
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		} 
		else if (waitStrategy == WaitStrategy.NONE) 
		{
			element = DriverManager.getDriver().findElement(by);
		} 
		
		return element;

	}

}
