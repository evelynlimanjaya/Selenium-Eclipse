package test;

import static org.testng.Assert.assertEquals;

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

import utility.constants;

public class day2Test {
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
    public void comparePrice() {
    	WebElement mobileTab=driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		mobileTab.click();
		String listPrice=driver.findElement(By.xpath("//*[@id='product-price-1']")).getText();
		WebElement xperia=driver.findElement(By.cssSelector("[title='Sony Xperia']"));
		xperia.click();
		String detailPrice=driver.findElement(By.cssSelector("span[class='price']")).getText();
		AssertJUnit.assertEquals(listPrice,detailPrice);
//		 try {
//			 assertEquals(listPrice, detailPrice); 
//		      } catch (Exception e) {
//		    	  e.printStackTrace();
//		      }
    }
    @AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
