package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ChromeOptions cOpt = new ChromeOptions();
	FirefoxOptions fOpt = new FirefoxOptions();
	EdgeOptions eOpt= new EdgeOptions();
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			cOpt.addArguments("--start-maximized"); 
			cOpt.addArguments("--incognito");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			fOpt.addArguments("--start-mazimized");
			fOpt.addArguments("-incognito");
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}else if(browserName.equalsIgnoreCase("Edge"))
		{
			eOpt.addArguments("--start-maximized");
			eOpt.addArguments("-incognito");
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
	}
	
	
	public WebDriver getdriver()
	{
		return driver.get();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.get().quit();
		}
	}
	
	public String getScreenShotPath(String testname, WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		Date d = new Date();
		String datenme= d.toString().replace(" ", "-").replace(":", "-"); 
		File source= ts.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir")+"\\Screenshots\\" +testname+datenme+".png";
		File destfile = new File(filepath);
		try {
			FileUtils.copyFile(source, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filepath;
	}
}
