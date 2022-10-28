package com.salesforce.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReports {
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static GenerateReports ob;
	
	private GenerateReports() {
		
	}
	
	private GenerateReports getInstance() {
		if (ob==null) {
			ob=new GenerateReports();
		}
		return ob;
	}
		
	public void extentreports() {
		htmlReporter = new ExtentHtmlReporter(Constants.Generate_Report_Path);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Salesforce");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Reeba");
		
		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("firebase regression tests");
		htmlReporter.config().setTheme(Theme.STANDARD);	
	}
	
	public void StartSingleTestReport(String testname) {
		logger =extent.createTest(testname);
	}
	
	public void logTestinfo(String message) {
		logger.log(Status.INFO,message);
	}
	
	public void TestPassed(String Testcasename) {
		logger.log(Status.PASS,MarkupHelper.createLabel(Testcasename+ "is passtest",ExtentColor.GREEN));
	}
	
	public void TestFailed(String Testcasename) {
		logger.log(Status.FAIL,MarkupHelper.createLabel(Testcasename+ "is failed",ExtentColor.RED));
	}
	
	public void endReport() {
		extent.flush();
	}
	
}
