import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import ReRunAutomation.ReRunAutomationScript;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	
	WebDriver driver;
	
	@Test(retryAnalyzer = ReRunAutomationScript.class)
	public void open() throws InterruptedException
	{
		 String projectpath= System.getProperty("user.dir");
		 System.out.println(projectpath);
		//WebDriverManager.chromedriver().avoidBrowserDetection().setup();
		//driver = new ChromeDriver();
		 Date date = new Date();
		 String date1= date.toString().replace(" ", "-").replace(":", "-");
		 System.out.println(date1);
		testfolderdelete d = new testfolderdelete();
		d.delete();
		System.setProperty("webdriver.firefox.driver", projectpath+"/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://ideastudioworld.com/");
		 String title =  driver.getTitle();
	       System.out.println(title);
	       assertEquals(title, "Idea Studio");
	       Thread.sleep(70000);
	       //File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        
	        File destFile = new File("./screenshot/"+date1+".png");
	        try {
	     	   FileUtils.copyFile( ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), destFile);
	        }catch(IOException e)
	        {
	     	   e.printStackTrace();
	        }
	       driver.close();
	}
	

}
