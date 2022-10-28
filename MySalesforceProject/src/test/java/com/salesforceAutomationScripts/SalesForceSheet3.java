package com.salesforceAutomationScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.Base.Base;

public class SalesForceSheet3 extends Base {
	//Testcase 10:Create an Account
	@Test
	public static void createaccount() throws InterruptedException {
		
		logintosalesforce();
        waituntilpageloads();
        WebElement accnt = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
        clickelement(accnt,"accnt");
        String actual=driver.getCurrentUrl();
        String expected="https://tekarch-ae-dev-ed.develop.my.salesforce.com/001/o";
        Assert.assertEquals(actual, expected);
        logger.info("Account page is displayed");
    //    driver.switchTo().frame("tryLexDialog");
        WebElement prompt = driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
        clickelement(prompt,"prompt");
     //   Alert alert=driver.switchTo().alert();
    //    logger.info(alert);
    //    alert.dismiss();
        Thread.sleep(5000);
     //   driver.switchTo().defaultContent();
     /*   WebElement acctname = driver.findElement(By.id("  acc2"));
        acctname.sendKeys("Tok");
        WebElement type = driver.findElement(By.id("acc6"));
        clickelement(type,"type");
        Select select=new Select(type);
    	select.selectByValue("Technology Partner");
    	logger.info("type selected");
        Thread.sleep(5000);
        WebElement priority = driver.findElement(By.id("00N4x00000WtvuP"));
        clickelement(priority,"priority");
        Select select1=new Select(priority);
    	select1.selectByValue("High");
    	logger.info("priority selected");
        WebElement savebutton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
        clickelement(savebutton,"savebutton");
        String actual1=driver.getCurrentUrl();
        String expected1="https://tekarch-ae-dev-ed.develop.my.salesforce.com/0014x00001RWPZT";
        Assert.assertEquals(actual1, expected1);
        logger.info("Account page is displayed");*/
        
	}
	
	//Testcase 11:Create new view
		@Test
		public static void createnewview() throws InterruptedException {
		logintosalesforce();
		waituntilpageloads();
	    WebElement accnt = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
	    clickelement(accnt,"accnt");
	    String actual=driver.getCurrentUrl();
	    String expected="https://tekarch-ae-dev-ed.develop.my.salesforce.com/001/o";
        Assert.assertEquals(actual, expected);
        logger.info("Account page is displayed");
	    Thread.sleep(5000);
	    WebElement newview = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
	    clickelement(newview,"newview");
	    WebElement viewname = driver.findElement(By.id("fname"));
	    viewname.sendKeys("jack");
	    WebElement uniquename = driver.findElement(By.id("devname"));
	    uniquename.sendKeys("ja");
	    WebElement savebutton = driver.findElement(By.xpath(" //*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
	    clickelement(savebutton,"savebutton");
		}

		//Testcase 12:Edit view
		@Test
		public static void editview() throws InterruptedException {
			
		logintosalesforce();
		waituntilpageloads();
	    WebElement accnt = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
	    clickelement(accnt,"accnt");
	    String actual=driver.getCurrentUrl();
	    String expected="https://tekarch-ae-dev-ed.develop.my.salesforce.com/001/o";
        Assert.assertEquals(actual, expected);
        logger.info("Account page is displayed");
	    Thread.sleep(5000);
	    WebElement viewmenu = driver.findElement(By.id("fcf"));
	    Select select1=new Select(viewmenu);
    	select1.selectByValue("00B4x00000Gh5oe");
    	logger.info("priority selected");
    	
    	WebElement edit = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
	    clickelement(edit,"edit");
	    
	   
		}
}
