package com.ot.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ot.annotations.FrameworkAnnotation;
import com.ot.reports.ExtentLogger;
import com.ot.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName()+" - "+result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + "Pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		ExtentLogger.fail(result.getMethod().getMethodName() + "Fail", true);
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + "Skip");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		System.out.println("We are not using this method as of now, We may use it further");
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		System.out.println("We are not using this method as of now, We may use it further");
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		System.out.println("We are not using this method as of now, We may use it further");
		 */
	}

}
