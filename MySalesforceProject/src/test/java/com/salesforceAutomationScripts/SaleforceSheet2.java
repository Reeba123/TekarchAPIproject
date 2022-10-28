package com.salesforceAutomationScripts;

import java.util.Set;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.salesforce.Base.Base;

public class SaleforceSheet2 extends Base {
	
	//Testcase 5:Select user menu for <username> drop down(Chrome)
	
	@Test
	public static void menudropdown() {

	logintosalesforce();
	waituntilpageloads();
	WebElement usermenu = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
	logger.info("usermenu found");
	clickelement(usermenu,"usermenu drop down");
	Assert.assertTrue(usermenu.isDisplayed());
	logger.info("User menu displayed");
	
		}
	
	//Testcase 6:Select "My Profile" option from user menu for <username> drop down(Chrome)
    	@Test
		public static void profileMenu () throws InterruptedException {

		logintosalesforce();
		waituntilpageloads();
		WebElement usermenu = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		clickelement(usermenu,"usermenu drop down");
		Assert.assertTrue(usermenu.isDisplayed());
		logger.info("Usermenu dropdown displayed");
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickelement(profile,"Clicked my profile");
	    Thread.sleep(5000);
	 	WebElement editbutton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		clickelement(editbutton,"Clicked editbutton");
		logger.info("window popup");
		waituntilpageloads();
		driver.switchTo().frame("contactInfoContentId");	
		Thread.sleep(5000);
		WebElement Abouttab = driver.findElement(By.xpath("//a[normalize-space()='About']"));
  		clickelement(Abouttab,"Clicked Abouttab");
  		WebElement lastname = driver.findElement(By.id("lastName"));
		clearelement(lastname,"lastname field cleared");
		lastname.sendKeys("Peter");
		logger.info("last name added");
		WebElement savebutton = driver.findElement(By.xpath("//input[@value='Save All']"));
		clickelement(savebutton,"Clicked savebutton");
		WebElement postlink = driver.findElement(By.id("publisherAttachTextPost"));
		clickelement(postlink,"Clicked postlink");
		Thread.sleep(5000);
		WebElement frame2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(frame2);
		WebElement postText = driver.findElement(By.xpath("/html/body"));
		postText.sendKeys("This is Test");
		logger.info("posted text");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		WebElement sharebutton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/span/input"));
		clickelement(sharebutton,"Clicked sharebutton");
		logger.info("text displayed");
		Thread.sleep(5000);
		WebElement filelink = driver.findElement(By.id("publisherAttachContentPost"));
		clickelement(filelink,"Clicked filelink");
		waituntilpageloads();
		WebElement uploadfile = driver.findElement(By.id("chatterUploadFileAction"));
		clickelement(uploadfile,"Clicked uploadfile");
		WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		choosefile.sendKeys("C:\\Users\\01nik\\Desktop\\Theory.pdf");
		logger.info("file selected");
		Thread.sleep(5000);
		WebElement sharebutton1 = driver.findElement(By.id("publishersharebutton"));
		clickelement(sharebutton1,"Clicked sharebutton");
		Thread.sleep(5000);
	    WebElement mousehover = driver.findElement(By.id("photoSection"));
	    Actions action = new Actions(driver);
	    action.moveToElement(mousehover).perform();
	    logger.info("mousehover the image");
		WebElement profphoto = driver.findElement(By.xpath("//*[@id=\"uploadLink\"]"));
		clickelement(profphoto,"Clicked profphoto");
		Thread.sleep(5000);
		driver.switchTo().frame("uploadPhotoContentId");
		WebElement choosefile1 = driver.findElement(By.xpath("/html/body/span/form/input[2]"));
		choosefile1.sendKeys("C:\\Users\\01nik\\Desktop\\9121d5d91999b21d40cadcec65645760.png");
		logger.info("photo uploaded successfully");
		Thread.sleep(5000);
		WebElement savebutton1 = driver.findElement(By.xpath("//body[1]/span[1]/form[1]/div[3]/input[2]"));
		clickelement(savebutton1,"Clicked savebutton1");
		Thread.sleep(5000);
		WebElement savebutton2 = driver.findElement(By.xpath("//body[1]/span[1]/form[1]/div[2]/input[1]"));
		clickelement(savebutton2,"Clicked savebutton2");
		logger.info("photo cropped and saved");
		driver.switchTo().defaultContent();
		}
    	
    	
    //Testcase 7:Select "My settings" option from user menu for <username> drop down
    	@Test
    	public static void settingsmenu () throws InterruptedException {
    	logintosalesforce();
    	waituntilpageloads();
    	WebElement usermenu = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
    	clickelement(usermenu,"usermenu drop down");
    	Assert.assertTrue(usermenu.isDisplayed());
    	logger.info("Usermenu dropdown displayed");	
    	WebElement settings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
    	clickelement(settings," my settings");
      	Thread.sleep(5000);
    	WebElement personal = driver.findElement(By.xpath("	//*[@id=\"PersonalInfo\"]/a"));
    	clickelement(personal,"Clicked personal");
    	WebElement loginlink = driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]"));
    	waituntilvisible(loginlink,"login history link ");
    	clickelement(loginlink," login history link");
    	waituntilpageloads();
    	WebElement downloadlink = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
    	clickelement(downloadlink," downloadlink");
    	Thread.sleep(5000);
    	WebElement dislaylink = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_font\"]"));
    	clickelement(dislaylink," dislaylink");
    	WebElement customizetab = driver.findElement(By.xpath("//*[@id=\"CustomizeTabs_font\"]"));
    	clickelement(customizetab," customize my tabs");
    	WebElement customapp = driver.findElement(By.xpath("//*[@id=\"p4\"]"));
    	clickelement(customapp," customapp");
    	Select select=new Select(customapp);
    	select.selectByValue("02u4x000002ESWr");
    	logger.info("Salesforce chatter selected");	
    	Thread.sleep(5000);
    	WebElement reporttab = driver.findElement(By.xpath("//*[@id=\"duel_select_0\"]/option[77]"));
    	clickelement(reporttab,"Clicked reporttab");
    	WebElement addbutton = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]"));
    	clickelement(addbutton,"Clicked addbutton");
    	WebElement savebutton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
    	clickelement(savebutton,"Clicked savebutton");
    	Thread.sleep(5000);
    	WebElement Emaillink = driver.findElement(By.id("EmailSetup"));
    	clickelement(Emaillink," Emaillink");
    	WebElement MyEmail = driver.findElement(By.xpath("//*[@id=\"EmailSettings_font\"]"));
    	clickelement(MyEmail,"My Email settings");
     	Thread.sleep(5000);
    	WebElement Emailname = driver.findElement(By.id("sender_name"));
    	clearelement(Emailname,"Email name field");
    	Emailname.sendKeys("Pete");
    	WebElement EmailAdress = driver.findElement(By.id("sender_email"));
    	clearelement(EmailAdress,"Email adress field");
    	EmailAdress.sendKeys("01.reeba@gmail.com");
    	WebElement Bccbutton = driver.findElement(By.id("auto_bcc1"));
    	clickelement(Bccbutton," Bccbutton");
    	WebElement Savebutton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
    	clickelement(Savebutton,"Savebutton");
    	Thread.sleep(5000);
      	WebElement calRem = driver.findElement(By.id("CalendarAndReminders"));
    	clickelement(calRem,"calRem");
    	WebElement ActivRem = driver.findElement(By.xpath("//*[@id=\"Reminders_font\"]"));
    	clickelement(ActivRem,"ActivRem");
    	WebElement Testrembutton = driver.findElement(By.id("testbtn"));
    	clickelement(Testrembutton,"Testrembutton");
    	Thread.sleep(5000);
    	String oldwindow=driver.getWindowHandle();
    	Set <String> getallwindows=driver.getWindowHandles();
    	String[] getwindow=getallwindows.toArray(new String[getallwindows.size()]);
    	driver.switchTo().window(getwindow[1]);
    	String result =" ";
    	if (getwindow[1] != getwindow[0]) {
    		 result="True";
    	}
    	else {  result="False";}
    	Assert.assertTrue(result.contains("True"));
    	logger.info("window displayed");
    	driver.switchTo().window(oldwindow);
    	
    	}
    	
    	 //Testcase 8:Select "Developers Console" option from user menu for <username> drop down
    	@Test
    	public static void devloperconsole ()throws InterruptedException {
    	logintosalesforce();
        waituntilpageloads();
        WebElement usermenu = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
        clickelement(usermenu,"usermenu drop down");
        Assert.assertTrue(usermenu.isDisplayed());
        logger.info("Usermenu dropdown displayed");	
        
        Thread.sleep(5000);
         
         WebElement devconsole = driver.findElement(By.xpath(" //*[@id=\"userNav-menuItems\"]/a[3]"));
         clickelement(devconsole," devconsole");
        String oldwindow=driver.getWindowHandle();
         Set <String> getallwindows=driver.getWindowHandles();
         String[] getwindow=getallwindows.toArray(new String[getallwindows.size()]);
         driver.switchTo().window(getwindow[1]);
         String result =" ";
        	if (getwindow[1] != getwindow[0]) {
        		 result="True";
        	}
        	else {  result="False";}
        	Assert.assertTrue(result.contains("True"));
        	logger.info("window displayed");
        	driver.close();
        	driver.switchTo().window(oldwindow);
    		
    	}
    	 //Testcase 9:Select "Logout" option from user menu for <username> drop down
    	
    	@Test
    	public static void Logoutmenu () {
    	logintosalesforce();
        waituntilpageloads();
        WebElement usermenu = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
        clickelement(usermenu,"usermenu drop down");
        Assert.assertTrue(usermenu.isDisplayed());
        logger.info("Usermenu dropdown displayed");	
        WebElement logout = driver.findElement(By.xpath("   //*[@id=\"userNav-menuItems\"]/a[5]"));
        clickelement(logout,"logout");
        String actual=driver.getCurrentUrl();
        String expected="https://tekarch-ae-dev-ed.develop.my.salesforce.com/secur/logout.jsp";
        Assert.assertEquals(actual, expected);
    		
    	}
	}
	

