package com.ot.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.ot.annotations.FrameworkAnnotation;
import com.ot.enums.AuthorType;
import com.ot.enums.CategoryType;
import com.ot.pages.ApertureLoginPage;

public final class ApertureLoginTest extends BaseTest {

	
	private ApertureLoginTest() {
		
	}
	
	
	@FrameworkAnnotation(author = {AuthorType.RAKESH}, category = {CategoryType.MINIREGRESSION})
	@Test
	public void loginLogoutTest(Map<String,String> data) {
		
		//ExtentReportManager.getExtentTest().assignAuthor("Rakesh Doreswamy").assignCategory("Smoke").assignCategory("Regression");
		String title = new ApertureLoginPage()
					   .enterUsername(data.get("username")).enterPassword(data.get("password")).clickSignIn()
			           .clickSignOutIconImage().clickSignOut()
			           .getTitle();
		
		Assertions.assertThat(title)
		.containsIgnoringCase("Connector Builder");		
	}
	
	@Test
	public void newTest(Map<String,String> data) {
		
		
		String title = new ApertureLoginPage()
					   .enterUsername(data.get("username")).enterPassword(data.get("password")).clickSignIn()
			           .clickSignOutIconImage().clickSignOut()
			           .getTitle();
		
		Assertions.assertThat(title)
		.containsIgnoringCase("Connector Builder");		
	}
	
	
	/*
	@FrameworkAnnotation(author = {AuthorType.RAKESH, AuthorType.RAHUL}, category = {CategoryType.MINIREGRESSION, CategoryType.SMOKE})
	@Test
	public void loginLogoutTest() {
		
		//ExtentReportManager.getExtentTest().assignAuthor("Rakesh Doreswamy").assignCategory("Smoke").assignCategory("Regression");
		String title = new ApertureLoginPage()
					   .enterUsername("pushkarb").enterPassword("Opentext@1234").clickSignIn()
			           .clickSignOutIconImage().clickSignOut()
			           .getTitle();
		
		Assertions.assertThat(title)
		.containsIgnoringCase("Connector Builder");		
	}
	*/
	
	
}
