package com.ot.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ot.constants.FrameworkConstants;
import com.ot.enums.ConfigProperties;
import com.ot.utility.PropertyUtils;

/**
 * Driver Class is responsible for invoking and closing the browsers.
 * 
 * <p>
 * It is also responsible for setting the driver variable to DriverManager which handles the thread safety for the WebDriver instance.
 * <p>
 * 
 * May 31, 2021 <p>
 * @author Rakesh Doreswamy
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.ot.tests.BaseTest
 */


public final class Driver {

	/**
	 * Private Constructor to avoid external instantiation
	 */
	private Driver() {
		
	}
	
	/**
	 * 
	 * @author Rakesh Doreswamy
	 * @version 1.0
	 * @param browser value will be passed from base test. values can be chrome and firefox
	 */
	public static void initDriver(String browser) {
		
		if (Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				//WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
				DriverManager.setDriver(new ChromeDriver());
				DriverManager.getDriver().manage().window().maximize();
				DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getImplicittimeout(), TimeUnit.SECONDS);
				
			}
			else if (browser.equalsIgnoreCase("firefox")){
				//WebDriverManager.firefoxdriver().setup();
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
				DriverManager.setDriver(new FirefoxDriver());
				DriverManager.getDriver().manage().window().maximize();
				DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getImplicittimeout(), TimeUnit.SECONDS);
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}
}
