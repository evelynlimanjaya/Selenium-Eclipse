package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.homepage;
import utility.constants;

public class day7Test {
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
  public void saveOrderTest() {
		objHomePage.accessMyAccountTest();
		objHomePage.loginTest();
		
  }
}
