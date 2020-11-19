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
import org.openqa.selenium.support.ui.Select;

public class day1Test {
	public WebDriver driver;
	public WebDriverWait wait;
	 private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("testProfile");
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(myProfile);
		driver =  new FirefoxDriver(opt);
		wait=new WebDriverWait(driver,5);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(constants.URL);
		driver.manage().window().maximize();
		
		
	}
	
	
	@Test
	public void verifyHomePage() {
//		String pageTitle=driver.getTitle();
//		assertEquals(pageTitle,"Home page");
		
		String demoSite  = driver.findElement(By.cssSelector("h2")).getText();
	    System.out.println(demoSite);
	    AssertJUnit.assertEquals("gfhfg", demoSite);	
	
	}
	
	@Test
	public void verifyMobilePage() {
		WebElement mobileTab=driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		mobileTab.click();
		String pageTitle=driver.getTitle();
		assertEquals(pageTitle,"Mobile");
		
	}
	
//	@Test
//	public void nameSort() throws InterruptedException {
//		Thread.sleep(2000);c
//		WebElement nameSort=driver.findElement(By.xpath("(//*[@title='Sort By'])[1]"));
//		nameSort.click();
////		Select drpSort=new Select(driver.findElement(By.xpath("(//*[@title='Sort By'])[1]")));
////		drpSort.selectByVisibleText("Name");
//		Thread.sleep(2000);
//	}
	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
