package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.constants;

public class day6Test {
	private WebDriver driver;
	private WebDriverWait wait;
	
	  @BeforeTest
	  public void launchBrowser() {
		  driver=new ChromeDriver();
		  driver.get(constants.URL);
		  driver.manage().window().maximize();
	  }
	  
	  @Test
	  public void placeOrder() {
			WebElement accountIcon=driver.findElement(By.cssSelector("[class='skip-link skip-account']"));
			accountIcon.click();
			WebElement myAccount=driver.findElement(By.cssSelector("[title='My Account']"));
			myAccount.click();
	  }
}
