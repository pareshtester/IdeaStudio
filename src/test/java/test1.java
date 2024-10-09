import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {

	WebDriver driver;
	@Test
	public void open()
	{
		//WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", "D:\\Automation\\IdeaSTUDIO\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile  myprofile  = profile.getProfile("C:\\Users\\teste\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\da4qvi95.Automation");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(myprofile);
		driver = new FirefoxDriver(options);
		driver.get("https://ideastudioworld.com/");
	}
}
