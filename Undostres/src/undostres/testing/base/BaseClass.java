package undostres.testing.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import undostres.testing.utilities.Getlogs;

public class BaseClass {
	public ChromeDriver driver;
	public Properties pr;
	public ChromeOptions options;
	@BeforeMethod()
	
	 public void setConnection() throws InterruptedException, IOException
	 {      //chromedriver setup
			System.setProperty("webdriver.chrome.driver", "../Undostres/chromedriver.exe");
			// for incognito mode of chrome
		    options = new ChromeOptions();
			options.addArguments("incognito");
			options.setExperimentalOption("useAutomationExtension", false);
		    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			DesiredCapabilities cap =DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);	
			// getting objectrepository file
			File fi =new File("../Undostres/ObjectsRepository.properties");
			FileInputStream f =new FileInputStream(fi);
			pr = new Properties();
			pr.load(f);
			driver  = new ChromeDriver(options);		
			driver.get("https://prueba.undostres.com.mx/"); //opening base Url
			Thread.sleep(5000L);
			Getlogs.logscapture("BaseClass", "Base URL opened");
			driver.manage().window().maximize();// maximizing window
			Thread.sleep(1000L);
	 }
	
@AfterMethod
	
	public void end() throws InterruptedException
	{ 

		driver.close();
	}

}




