package com.ot.pages;

import org.openqa.selenium.By;

import com.ot.enums.WaitStrategy;

public class ApertureHomePage extends BasePage{
	
	private final By imgSigOutIcon = By.xpath("//img[@alt='User']");
	private final By linkSignOut = By.xpath("//li[contains(text(),'Sign out')]");
	
	ApertureHomePage() {
		
	}
	
	public ApertureHomePage clickSignOutIconImage() {
		
		click(imgSigOutIcon, WaitStrategy.CLICKABLE,"SignOut Icon Image");
		return this;
		
	}
	public ApertureLoginPage clickSignOut() {
	
		click(linkSignOut, WaitStrategy.CLICKABLE,"SignOut Link");
		return new ApertureLoginPage();
	}
	
	
	
	
	
}
