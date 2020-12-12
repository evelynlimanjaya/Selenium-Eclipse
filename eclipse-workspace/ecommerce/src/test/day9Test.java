package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.homepage;
import utility.constants;

public class day9Test {
	private WebDriver driver;
	private WebDriverWait wait;
	private String email="crimson.eve@gmail.com";
	private String password ="bobamilktea";
	private String couponCode="GURU50";

	homepage objHomePage;
	
	@BeforeTest
	  public void launchBrowser() {
		  driver=new ChromeDriver();
		  driver.get(constants.URL);
		  driver.manage().window().maximize();
	  }
	
    @Test
    public void couponTest() {
    	objHomePage=new homepage(driver);
    	objHomePage.accessMobileMenu();
    	WebElement iPhoneCart=driver.findElement(By.xpath("(//*[@title='Add to Cart'])[2]"));
    	iPhoneCart.click();
    	WebElement discountInput=driver.findElement(By.cssSelector("#coupon_code"));
    	discountInput.sendKeys(couponCode);
    	WebElement applyBtn=driver.findElement(By.cssSelector("[title='Apply']"));
    	applyBtn.click();
    	String oriPrice=driver.findElement(By.xpath("(//*[@class='a-right'])[4]")).getText().replace("$", "");
    	double oriPriceNum=Double.parseDouble(oriPrice);
    	double discountPrice=oriPriceNum*0.05;
    	String discountPriceStr=Double.toString(discountPrice);
    	String actualDiscount=driver.findElement(By.xpath("(//*[@class='a-right'])[6]")).getText();
    	
    	try {
			 Assert.assertTrue(actualDiscount.contains(discountPriceStr)); 
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      }
    	
    	
    }
    
    @AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
