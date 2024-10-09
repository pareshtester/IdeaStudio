import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ReRunAutomation.ReRunAutomationScript2;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testextentreport {
	
	WebDriver driver;
	
	 public ExtentSparkReporter spark;
	 ExtentReports  ET = new ExtentReports();
	 ExtentTest ettest; 
	String reportspath ="reportnew.html";
	String screenshotpath ="webpageSS.png";
	    ExtentReports extent;
	     ExtentTest test;
	     
	
	@BeforeTest
	 public void setup()
	 {  
   	 File f = new File("reportnew.html");
		 spark = new ExtentSparkReporter(f);
		 spark.config().setReportName("Web Automation Results");

		 spark.config().setDocumentTitle("Test Results");
		  ET = new ExtentReports();
		 ET.attachReporter(spark);
		
	 }
	
	@Test(retryAnalyzer = ReRunAutomationScript2.class)
	public void open() throws InterruptedException
	{
		 ettest = ET.createTest("This is pass1") ;
		 ettest.log(Status.PASS, "Pass test1");
		 
		//WebDriverManager.chromedriver().avoidBrowserDetection().setup();
		//driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "D:\\Automation\\IdeaSTUDIO\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://ideastudioworld.com/");
		 String title =  driver.getTitle();
	       System.out.println(title);
	       assertEquals(title, "Idea Studio");
	       Thread.sleep(70000);
	       File screenshotfile =
	  			  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        
	        File destFile = new File("./screenshot/webpageSS.png");
	        try {
	     	   FileUtils.copyFile(screenshotfile, destFile);
	        }catch(IOException e)
	        {
	     	   e.printStackTrace();
	        }
	        ettest.addScreenCaptureFromPath("./screenshot/ss.png" , "Testing website status");
	        
	       driver.close();
	}
	

}
