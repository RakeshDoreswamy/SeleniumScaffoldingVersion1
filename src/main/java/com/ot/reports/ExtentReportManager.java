package com.ot.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
	
private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	private ExtentReportManager() {
		
	}
	
	static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	
	static void setExtentTest(ExtentTest test) {
		extentTest.set(test);	
	}
	
	static void unload() {
		extentTest.remove();
	}

}

