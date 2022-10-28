package com.salesforceAutomationScripts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.salesforce.utility.Constants;

public class ExtentReportSalesforce {
		
		ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest logger;
		private static ExtentReportSalesforce ob;
		
		private ExtentReportSalesforce() {
			
		}
		
		public static ExtentReportSalesforce getInstance() {
			
			System.out.println("1");
			if (ob==null) {
				System.out.println("2");
				ob=new ExtentReportSalesforce();
			}
			System.out.println("3");
			return ob;
		}
		
		public void StartExtentReport() {
			System.out.println("4");	
		htmlReporter = new ExtentHtmlReporter(Constants.Generate_Report_Path);
		extent = new ExtentReports();
		System.out.println("5");
		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("firebase regression tests");
		htmlReporter.config().setTheme(Theme.STANDARD);
		System.out.println("6");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Salesforce");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Reeba");
		}
	   public static void SingleTestReport (String testname) {
		    System.out.println("6a");
			logger=extent.createTest(testname);
			System.out.println("7");	
		}
		
		public static void logtestinfo (String message) {
			System.out.println("8");
			logger.log(Status.INFO, "hello world");
			
		}
		
		public static void logtestpassed (String testcasename) {
			System.out.println("9");
			logger.log(Status.INFO, MarkupHelper.createLabel(testcasename+"is pass test",ExtentColor.GREEN ));
			
		}
		
		public static void logtestfailed (String testcasename) {
			System.out.println("10");
			logger.log(Status.INFO, MarkupHelper.createLabel(testcasename+"is fail Test",ExtentColor.RED ));
			
		}
		
		

		public static void endreport() {
			extent.flush();
			System.out.println("completed");
			
		}

}
