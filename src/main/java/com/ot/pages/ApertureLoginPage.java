package com.ot.pages;

import org.openqa.selenium.By;

import com.ot.enums.WaitStrategy;
import com.ot.utility.DecodeUtils;

public final class ApertureLoginPage extends BasePage{

	private final By textboxUsername = By.id("username");
	private final By textboxPassword = By.xpath("//input[@id='password' and @type='password']");
	private final By buttonLogin= By.xpath("//button[contains(text(),'Sign in')]"); // Another Xpath - //button[text()='Sign in']

	public ApertureLoginPage enterUsername(String username) {
		sendKeys(textboxUsername,username, WaitStrategy.PRESENCE,"Username");
		return this;
	}

	public ApertureLoginPage enterPassword(String password) {
		sendKeys(textboxPassword,DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password");
		return this;
	}

	public ApertureHomePage clickSignIn() {
		click(buttonLogin, WaitStrategy.PRESENCE,"Sign in Button");
		return new ApertureHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}

}
