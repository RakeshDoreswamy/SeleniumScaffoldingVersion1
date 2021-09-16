package com.ot.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	private DriverManager() {
		
	}
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver driverRef) {
		dr.set(driverRef);	
	}
	
	public static void unload() {
		dr.remove();
	}

}
