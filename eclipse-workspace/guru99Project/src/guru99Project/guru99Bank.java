package guru99Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;

public class guru99Bank {
	public static void main() {
		// declaration and instantiation of objects/variables
//    	System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
//		System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://www.demo.guru99.com/V4/";
		
		driver.get(baseUrl);
		
		WebElement UserID=driver.findElement(By.cssSelector("[name='uid']"));
		WebElement Password=driver.findElement(By.cssSelector("[name='password']"));
		WebElement Login=driver.findElement(By.cssSelector("[name='btnLogin']"));
		
		UserID.sendKeys("mngr293142");
		Password.sendKeys("Egugyje");
		Login.click();
		
		
	}
	

}
