package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.constants;

public class day3Test {
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
    public void cartTest() throws InterruptedException {
    	WebElement mobileTab=driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		mobileTab.click();
		WebElement addToCart=driver.findElement(By.xpath("(//*[@title='Add to Cart'])[1]"));
		addToCart.click();
		WebElement qtyInput=driver.findElement(By.cssSelector("[class='input-text qty']"));
		WebElement update=driver.findElement(By.xpath("(//span[contains(text(),'Update')])[1]"));
		qtyInput.clear();
		qtyInput.sendKeys("1000");
		update.click();
		WebElement errorMsg=driver.findElement(By.cssSelector("[class='item-msg error']"));
		String errorMsgContent=errorMsg.getText();
		System.out.print(errorMsgContent);
		
		
    }
}
