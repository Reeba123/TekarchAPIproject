package com.salesforce.Base;

import java.lang.reflect.Method;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.salesforce.utility.Testutility;
import com.salesforceAutomationScripts.ExtentReportSalesforce;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Logger logger=(Logger) LogManager.getLogger(Base.class);
	public static ExtentReportSalesforce report;
	
	public static void getdriver(String browser) {
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		default:
			break;
		}
			
		}
	
	@BeforeTest
	public static void beforetest() {
		report=ExtentReportSalesforce.getInstance();
		report.StartExtentReport();
	
		
	}
	
	
	@Parameters({"browsername"})
	@BeforeMethod
	public static void setUp(String browsername,Method m) {
		System.out.println("inbrws");
		System.out.println(browsername);
		System.out.println("a");
		ExtentReportSalesforce.logtestinfo("Before execution started");
		System.out.println("aaa");
		ExtentReportSalesforce.SingleTestReport(m.getName());
		System.out.println("b");
		getdriver(browsername);
		System.out.println("c");
		Testutility tu=new Testutility();
		System.out.println("d");
		String Url=tu.getapplicationproperty("url");
		System.out.println("e");
		gotourl(Url);
		System.out.println("f");
		waituntilpageloads();
		System.out.println("g");
		System.out.println("last");
	}
	
	
	@AfterMethod
	public static void tearDown() {
		ExtentReportSalesforce.logtestinfo("testcase passed");;	
		closebrowser();
	}
	
	@AfterTest
	public static void aftertest() {
		ExtentReportSalesforce.endreport();
	}
	
	public static void logintosalesforce() {
		Testutility tu=new Testutility();
		System.out.println("inmidd");
		String Username=tu.getapplicationproperty("username");
		String Password=tu.getapplicationproperty("password");
		WebElement username=driver.findElement(By.id("username"));
		entertext(username,Username," username entered");
		WebElement password=driver.findElement(By.id("password"));
		entertext(password,Password," password entered");
		WebElement button = driver.findElement(By.id("Login"));
		clickelement(button," Login button");
		System.out.println("2");
		
	}

	public static void entertext(WebElement element, String text, String objname) {
		if (element.isDisplayed()) {
			System.out.println("3");
			clearelement(element, objname);
			element.sendKeys(text);
			ExtentReportSalesforce.logtestinfo("Pass " + text + objname);
		} else {
		ExtentReportSalesforce.logtestfailed("Fail " + text + objname);;
		}
		System.out.println("4");
	}

	public static void clearelement(WebElement element, String objname) {
		if (element.isDisplayed()) {
			element.clear();
			ExtentReportSalesforce.logtestinfo("pass - cleared " + objname);;
		} else {
			ExtentReportSalesforce.logtestfailed("Fail - Not cleared " + objname);
		}
	}

	public static void clickelement(WebElement element, String objname) {
		if (element.isDisplayed()) {
			element.click();
			ExtentReportSalesforce.logtestinfo("pass -clicked " + objname);
		} else {
			ExtentReportSalesforce.logtestfailed("Fail - Not clicked " + objname);
		}
	}

	public static void waituntilvisible(WebElement element, String objname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waituntilelementclickable(By locator, String objname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waituntilpageloads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}

	public static void gotourl(String url) {
		driver.get(url);
		ExtentReportSalesforce.logtestinfo("url opened");
	}
	
	public static void refreshpage() {
		driver.navigate().refresh();
		ExtentReportSalesforce.logtestinfo("page Refreshed");
	}
	
	public static void pagetittle() {
		driver.getTitle();
		ExtentReportSalesforce.logtestinfo("page tittle");
	}
	
	public static void closebrowser() {
		driver.close();
		ExtentReportSalesforce.logtestinfo("closebrowser");
	}

	public static void closeallbrowser() {
		driver.quit();
		ExtentReportSalesforce.logtestinfo("closed all browser");
	}
}
