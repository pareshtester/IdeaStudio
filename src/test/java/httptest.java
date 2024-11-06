import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ReRunAutomation.ReRunAutomationScript;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.trace.StatusCode;

public class httptest {
	
	WebDriver driver;
	
	@Test(retryAnalyzer = ReRunAutomationScript.class)
	public void open() throws InterruptedException
	{
		 int statusCode = -1;
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
		// 11th nov //https://www.ideastudio.world/
		//driver.get("https://ideastudioworld.com/");
		String urlString ="https://ideastudioworld.com/";
		  HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                                         .uri(URI.create(urlString))
	                                         .GET()
	                                         .build();
		 try {
	            
			 HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
	             statusCode = response.statusCode();
	            System.out.println("HTTP Status Code: " + statusCode);
	        } catch (Exception e) {
	            System.err.println("Error checking status code: " + e.getMessage());
	        }
		 if(statusCode == 200){
			 SoftAssert soft = new SoftAssert();
			 driver = new FirefoxDriver();
			 driver.get(urlString);
			 String title =  driver.getTitle();
		      // System.out.println(title);
		       soft.assertEquals(title, "Idea1 Studio");
		       assertEquals(title, "Idea Studio");
		       System.out.println("still running");
		       Thread.sleep(1000);
		       //File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        
		        File destFile = new File("./screenshot/"+date1+".png");
		        try {
		     	   FileUtils.copyFile( ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), destFile);
		        }catch(IOException e)
		        {
		     	   e.printStackTrace();
		        }
		       driver.close();
			 
		 }else
		 {
			 
			  System.out.println("in error section");
			 driver = new FirefoxDriver();
			 driver.get(urlString);
			 Thread.sleep(70000);
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
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
