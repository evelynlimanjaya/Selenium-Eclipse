package guru99Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class guru99Bank {
	public static void main(String[] args) {
		
		// declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
//		System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,5);
		
		String baseUrl = "http://www.demo.guru99.com/V4/";
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		WebElement UserID=driver.findElement(By.cssSelector("[name='uid']"));
		WebElement Password=driver.findElement(By.cssSelector("[name='password']"));
		WebElement Login=driver.findElement(By.cssSelector("[name='btnLogin']"));
		
		UserID.sendKeys("mngr293142");
		Password.sendKeys("Egugyje");
		Login.click();

		WebElement titleSelector= driver.findElement(By.cssSelector("marquee[class='heading3']"));
//		wait.until(ExpectedConditions.visibilityOf(titleSelector));
		String titleText=titleSelector.getText();
		
		if(titleText.equals("Welcome To Manager's Page of Guru99 Bank")) {
			System.out.print("Test Passed");
		}
		else {
			System.out.print("Test Failed");
		}
		
		driver.close();
		
		
	}
	

}
