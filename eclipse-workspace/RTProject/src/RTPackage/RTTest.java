package RTPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RTTest {
	public String baseUrl = "https://roughandtumbledesign.com";
    public WebDriver driver ; 
    
  @BeforeTest
  public void launchBrowser() {
	  driver=new ChromeDriver();
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }
  
  @BeforeMethod
  public void clickSearchIcon() throws InterruptedException {
	  WebDriverWait wait=new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='search-header__input search__input']")));
	  driver.findElement(By.cssSelector("[class='search-header__input search__input']")).click();
	
  }
  
  @Test
  public void searchTest() throws InterruptedException{
	  driver.findElement(By.cssSelector("#SearchInput")).sendKeys("hobo"+ Keys.ENTER);
	  Thread.sleep(5000);
  }
  
//  @AfterMethod
//  public void() {
//	  
//  }
  
  @AfterTest
  public void terminateBrowser() {
	  driver.close();
  }
}
