import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTesting {
	
	WebDriver driver;
	
	@Test
	public void open()
	{
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		//WebDriver driver;
	     //  WebDriverManager.chromedriver().setup();
		
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("useAutomationExtension", false);
//		options.addArguments("test-type");
//    options.addArguments("start-maximized");
//	    options.addArguments("--js-flags=--expose-gc");
//	    options.addArguments("--enable-precise-memory-info");
//    options.addArguments("--disable-popup-blocking");
//	    options.addArguments("--disable-default-apps");
//    options.addArguments("--enable-automation");
//	    options.addArguments("test-type=browser");
//   options.addArguments("disable-infobars");
//    options.addArguments("disable-extensions");
//options.addExtensions(new File("C:\\Users\\teste\\Downloads\\WhatFont 3.2.0.0.crx"));
	   // options.addArguments("load-extension=C:/Users/teste/Downloads/WhatFont 3.2.0.0.crx");
		//options.setExperimentalOption("useAutomationExtension", false);
		//options.addExtensions(new File("ChroPath.crx"));
       
//       driver = new ChromeDriver();
//       driver.manage().window().maximize();
		//WebDriverManager.firefoxdriver().setup();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile  myprofile  = profile.getProfile("Automation");
		//driver = new FirefoxDriver(myprofile);
		driver.get("https://ideastudioworld.com/");
      // driver.get("https://ideastudioworld.com/");
		//driver.manage().window().maximize();

		//driver.get("https://ideastudioworld.com/");
		//driver.close();
       
       String title =  driver.getTitle();
       System.out.println(title);
       assertEquals(title, "Idea Studio");
	}
	
	@AfterTest
  public void close()
  {
	  driver.close();
  }
}
