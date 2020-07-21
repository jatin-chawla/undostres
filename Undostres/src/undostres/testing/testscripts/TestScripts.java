package undostres.testing.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import undostres.testing.assertion.Assertion_;
import undostres.testing.base.BaseClass;
import undostres.testing.utilities.Getlogs;

public class TestScripts extends BaseClass {
	
@Test
			public void first() throws InterruptedException, IOException
			{
			try {//entering the Recharge details All webelements are stored in Object repository
	         driver.findElement(By.name(pr.getProperty("operator"))).click();
	         Thread.sleep(500L);
	         driver.findElement(By.cssSelector(pr.getProperty("selectoperator"))).click();
	         driver.findElement(By.name(pr.getProperty("mobile"))).sendKeys("5523261151");
	         driver.findElement(By.name(pr.getProperty("amount"))).click();
	         Thread.sleep(500L);
	         driver.findElement(By.cssSelector(pr.getProperty("selectammount10$"))).click();
             driver.findElement(By.cssSelector(pr.getProperty("paybutton1"))).click();
	         Thread.sleep(1500L);
	         Getlogs.logscapture("TestScripts", "details Filled and moved to payment page");
			}
			catch (Exception e) {
			 Getlogs.logscapture("TestScripts", "not able to fill details");
			}
			
			try {//entering the Card details All webelements are stored in Object repository
	         driver.findElement(By.xpath(pr.getProperty("cardname"))).sendKeys("test");	      
	         driver.findElement(By.xpath(pr.getProperty("cardnum"))).sendKeys("4111111111111111");
	         driver.findElement(By.xpath(pr.getProperty("month"))).sendKeys("11");
	         driver.findElement(By.xpath(pr.getProperty("year"))).sendKeys("2025");
	         driver.findElement(By.xpath(pr.getProperty("cvvno"))).sendKeys("111");
	         driver.findElement(By.xpath(pr.getProperty("emailid1"))).sendKeys("test@test.com");
	         Thread.sleep(1000L);
	         driver.findElement(By.xpath(pr.getProperty("paybutton2"))).click();
	         Thread.sleep(1000L);
	         Getlogs.logscapture("TestScripts", "payment details filled");
			 }
			catch (Exception e) {
				Getlogs.logscapture("TestScripts", "not able to Fill payment details");
			 }
			//entering the User login details All webelements are stored in Object repository
			 try {
	         driver.findElement(By.xpath(pr.getProperty("username"))).sendKeys("jatinkc.14@gmail.com");
	         driver.findElement(By.xpath(pr.getProperty("psw"))).sendKeys("Jatin@123");
	         Thread.sleep(1000L);
	         new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(pr.getProperty("recapcha1"))));
	         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(pr.getProperty("recapcha2")))).click();
	         Thread.sleep(5000L);
	         // Above code is for handling google recaptch2.0 only.Usally developer bypass this for testers
	         driver.switchTo(). defaultContent();
	         driver.findElement(By.name(pr.getProperty("login"))).click();
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         Thread.sleep(1000l);
	         Getlogs.logscapture("TestScripts", "Payment Done");
	         
			 }
			 catch (Exception e) {
				 Getlogs.logscapture("TestScripts", "Payment Failed by user");
			 }
			 
			 // checking final result with Assertion
	         String Payment_result=driver.findElementByCssSelector(pr.getProperty("rechargestatus")).getText();
	         System.out.println(Payment_result);
	         Thread.sleep(1000l);
	         Assertion_.checkequal(Payment_result);
	         Thread.sleep(2000l);
	         Getlogs.logscapture("TestScripts", "Payment results captured");
	         Thread.sleep(1000l);
		}

}
