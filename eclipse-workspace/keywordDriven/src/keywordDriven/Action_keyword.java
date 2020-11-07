package keywordDriven;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Constants; 
public class Action_keyword {
	public static WebDriver driver; 
	public void openBrowser() 
	{

//	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe"); 
	WebDriver driver = new ChromeDriver(); 
	driver.manage().window().maximize(); 
	} 
	public void navigate() 
	{ 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.get(Constants.URL); 
	} 
	public void enterEmail() 
	{ 
	driver.findElement(By.xpath("//input[@id='user_email_login']")).sendKeys(Constants.username); 
	} 
	public void enterPassword() 
	{ 
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(Constants.password); 
	} 
	public void clickSignIn() 
	{ 
	driver.findElement(By.xpath("//form[@id='signin_signup_form']//input[@id='user_submit']")).click(); 
	}

	public void logout() 
	{ 
	driver.findElement(By.xpath("//a[@id='sign_out_link']")).click(); 
	} 
	public void closeBrowser() 
	{ 
	driver.quit(); 
	} 
}
