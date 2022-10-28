package com.salesforceAutomationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.Base.Base;


public class SalesForceSheet1 extends Base {
	//Testcase 1:Navigate to SFDC(firefox)
	@Test
	public static void Navigsfdc() {
		
		WebElement Username=driver.findElement(By.id("username"));
		waituntilvisible(Username," username field");
		entertext(Username,"reeba@tekarch.com"," username Entered");
		WebElement Password=driver.findElement(By.id("password"));
		entertext(Password,"","password field");
		WebElement button=driver.findElement(By.id("Login"));
		clickelement(button, "Login button");
		waituntilpageloads();
		String actual =driver.findElement(By.xpath("//div[@id='error']")).getText();
		String expected = "Please enter your password.";
	    Assert.assertEquals(actual, expected);	
	}
	
	//Testcase 2:Login to SFDC(firefox)
	@Test
	public static void Login() {
	
	logintosalesforce();
	logger.info("This is test logger");
	}
	
	//Testcase 3:Test the remember username check box (firefox)
	@Test
	public static void RembUser() throws InterruptedException {

	gotourl("https://www.salesforce.com/login");
	waituntilpageloads();
	WebElement Username=driver.findElement(By.id("username"));
	entertext(Username,"reeba@tekarch.com","  username field");
	WebElement Password=driver.findElement(By.id("password"));
	entertext(Password,"Iamlogin1","  password field");
	WebElement remb = driver.findElement(By.name("rememberUn"));
	clickelement(remb,"  Remember username clicked");
	WebElement button = driver.findElement(By.id("Login"));
	clickelement(button," Login button clicked");
	waituntilpageloads();
	Thread.sleep(8000);
	WebElement usermenu = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
	clickelement(usermenu,"  user menu drop down");
	WebElement logoutt = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
	clickelement(logoutt,"  logout clicked");
	waituntilpageloads();
	Thread.sleep(5000);
	WebElement username1 = driver.findElement(By.name("username"));
	String actual=username1.getAttribute("value");
	String expected="reeba@tekarch.com";
	Assert.assertEquals(actual, expected);
	
	}
	
	//Testcase 4A:Test forgot password(Chrome)
	@Test
	public static void forgtPswrd() {
	
	gotourl("https://www.salesforce.com/login");
	waituntilpageloads();
	WebElement fgtpwd=driver.findElement(By.id("forgot_password_link"));
	clickelement(fgtpwd,"Forgot password");
	WebElement username=driver.findElement(By.id("un"));
	entertext(username,"reeba@tekarch.com","Email id");
	WebElement button=driver.findElement(By.name("continue"));
	clickelement(button,"continue button");
	String actual=driver.findElement(By.className("message")).getText();
	Assert.assertTrue(actual.contains("We’ve sent you an email with a link to finish resetting your password."));
	
	}
	
	//Test case 4B-ValidateLoginErrorMessage(Chrome)
	@Test(description="Test case 4B-ValidateLoginErrorMessage(Chrome)")
	public static void valerrormsg() {
	
	gotourl("https://www.salesforce.com/login");
	waituntilpageloads();
	WebElement username = driver.findElement(By.id("username"));
	entertext(username,"123","Username field");
	WebElement password = driver.findElement(By.id("password"));
	entertext(password,"22131","Password field");
	WebElement login = driver.findElement(By.id("Login"));
	clickelement(login,"Login button");
	String actual = driver.findElement(By.id("error")).getText();
	String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	Assert.assertEquals(actual, expected);
	
	}
	
}


