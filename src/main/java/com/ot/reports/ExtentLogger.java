package com.ot.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.ot.enums.ConfigProperties;
import com.ot.utility.PropertyUtils;
import com.ot.utility.ScreenshotUtils;

public final class ExtentLogger {


	private ExtentLogger() {}

	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message);
	}
	
	public static void info(String message) {
		ExtentReportManager.getExtentTest().info(message);
	}
	
	public static void pass(String message, boolean isScreenshotRequired) { 
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotRequired) {
			ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message, boolean isScreenshotRequired) {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotRequired) {
			ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	public static void skip(String message, boolean isScreenshotRequired) {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotRequired) {
			ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}
	
	
}

