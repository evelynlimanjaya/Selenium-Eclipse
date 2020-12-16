package keywordDriven;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Constants; 
public class Action_keyword {
	public static WebDriver driver= new ChromeDriver(); 

	public void openBrowser() 
	{

//	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe"); 
	driver.get(Constants.URL);
	driver.manage().window().maximize(); 
	} 
	public void navigate() 
	{ 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
 
	} 
	public void input() 
	{ 
	driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Constants.searchInput);
	} 
	public void clickEnter() 
	{ 
	driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER); 
	} 
	public void checkResult() 
	{ 
	String resultText=driver.findElement(By.cssSelector("#res")).getText(); 
	try {
		 resultText.contains(Constants.searchResult); 
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}
	public void closeBrowser() 
	{ 
	driver.quit(); 
	} 
}
