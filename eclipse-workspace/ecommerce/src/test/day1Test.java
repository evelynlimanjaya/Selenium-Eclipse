package test;
import utility.constants;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1Test {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("testProfile");
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(myProfile);
		driver =  new FirefoxDriver(opt);
		wait=new WebDriverWait(driver,5);
		
		driver.get(constants.URL);
		driver.manage().window().maximize();
		
		
	}
	
	
	@Test
	public void nameSort() {
		String pageTitle=driver.getTitle();
		assertEquals(pageTitle,"Home pag");
	
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
