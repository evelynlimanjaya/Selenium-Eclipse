package test;
import utility.constants;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
//		driver.manage().window().maximize();
		
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePage() {
		String pageTitle=driver.getTitle();
		AssertJUnit.assertEquals(pageTitle,"Home page");	
	
	}
	
	@Test(priority=2)
	public void verifyMobilePage() {
		WebElement mobileTab=driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		mobileTab.click();
		String pageTitle=driver.getTitle();
		AssertJUnit.assertEquals(pageTitle,"Mobile");
		
	}
	
	@Test(priority=3)
	public void nameSort() throws InterruptedException {
		Select drpSort=new Select(driver.findElement(By.xpath("(//*[@title='Sort By'])[1]")));
		drpSort.selectByVisibleText("Name");
		Thread.sleep(2000);
	}
	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
