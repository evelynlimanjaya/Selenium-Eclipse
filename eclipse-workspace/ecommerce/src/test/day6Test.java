package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.webElements;
import PageFactory.homepage;

import utility.constants;

public class day6Test {
	private WebDriver driver;
	private WebDriverWait wait;
	private String email="crimson.eve@gmail.com";
	private String password ="bobamilktea";

	homepage objHomePage;
	
	  @BeforeTest
	  public void launchBrowser() {
		  driver=new ChromeDriver();
		  driver.get(constants.URL);
		  driver.manage().window().maximize();
	  }
	  
	  @Test
	  public void placeOrder() {
//			WebElement accountIcon=driver.findElement(By.cssSelector("[class='skip-link skip-account']"));
//			accountIcon.click();
//			WebElement myAccount=driver.findElement(By.cssSelector("[title='My Account']"));
//			myAccount.click();
//			WebElement emailLogin=driver.findElement(By.id("email"));
//			emailLogin.clear();
//			emailLogin.sendKeys(email);
//			WebElement passLogin=driver.findElement(By.id("pass"));
//			passLogin.clear();
//			passLogin.sendKeys(password);
//			WebElement loginBtn=driver.findElement(By.id("send2"));
//			loginBtn.click();
//			accountIcon.click();
//			WebElement wishlist=driver.findElement(By.xpath("//a[contains(text(),'My Wishlist')]"));
//			wishlist.click();
//			WebElement addToCart=driver.findElement(By.cssSelector("[title='Add to Cart']"));
//			addToCart.click();
//			WebElement checkout=driver.findElement(By.cssSelector("[title='Proceed to Checkout']"));
//			checkout.click();
			
			objHomePage=new homepage(driver);
			objHomePage.accessMyAccountTest();
			objHomePage.loginTest();
			objHomePage.addToCartTest();
	  }
}
