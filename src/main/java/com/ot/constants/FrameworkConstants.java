package com.ot.constants;

import com.ot.enums.ConfigProperties;
import com.ot.utility.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {
		System.out.println("Private Frameworks Constant Defined, So We can't create an object");
	}

	
	private static final int IMPLICITTIMEOUT = 10;
	private static final int EXPLICITTIMEOUT = 10;
	private static final String PATHTORESOURCE = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = PATHTORESOURCE + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = PATHTORESOURCE + "/executables/geckodriver.exe";
	private static final String PROPERTYFILEPATH = PATHTORESOURCE + "/config/config.properties";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String EXCELPATH = System.getProperty("user.dir")+"/excel/TestData.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";


	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}

	public static int getImplicittimeout() {
		return IMPLICITTIMEOUT;
	}

	public static int getExplicittimeout() {
		return EXPLICITTIMEOUT;
	}

	public static String getExtentreportfilepath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath() {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}

	

}
