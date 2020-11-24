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
	
    @Test(priority=1)
    public void cartTest() throws InterruptedException {
    	WebElement mobileTab=driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		mobileTab.click();
		WebElement addToCart=driver.findElement(By.xpath("(//*[@title='Add to Cart'])[1]"));
		addToCart.click();
		WebElement qtyInput=driver.findElement(By.cssSelector("[class='input-text qty']"));
		qtyInput.clear();
		qtyInput.sendKeys("1000");
		WebElement update=driver.findElement(By.cssSelector("[class='button btn-update"));
		update.click();
		WebElement errorMsg=driver.findElement(By.cssSelector("[class='item-msg error']"));
		String errorMsgContent=errorMsg.getText();
		try {
			 assertEquals(errorMsgContent, "* The maximum quantity allowed for purchase is 500."); 
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      }
		
    }
    @Test(priority=2)
    public void emptyCart() {
    	WebElement emptyCrtBtn=driver.findElement(By.cssSelector("[class='button2 btn-empty']"));
    	emptyCrtBtn.click();
    	WebElement cartEmpty=driver.findElement(By.cssSelector("[class='cart-empty']"));
    	String emptyMsg=cartEmpty.getText();
    	try {
			 assertEquals(emptyMsg, "You have no items in your shopping cart.\n"
			 		+ "Click here to continue shopping."); 
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      }
    	c
    }
    @AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
