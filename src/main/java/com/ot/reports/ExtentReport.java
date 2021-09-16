package com.ot.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ot.constants.FrameworkConstants;
import com.ot.enums.AuthorType;
import com.ot.enums.CategoryType;

public final class ExtentReport {

	private static ExtentReports extent;
	public static ExtentTest extentTest;

	private ExtentReport() {

	}

	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath()); 
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation A2A Report");
			spark.config().setReportName("A2A Detailed Report");
		}
	}

	public static void flushReports() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentReportManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void createTest(String testCaseName) {
		ExtentTest	extentTest = extent.createTest(testCaseName);
		ExtentReportManager.setExtentTest(extentTest);
	}

	public static void addAuthors(AuthorType[] authors) {
		for(AuthorType temp: authors) {
			ExtentReportManager.getExtentTest().assignAuthor(temp.toString());
		}
		
	}

	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp: categories) {
			ExtentReportManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}


