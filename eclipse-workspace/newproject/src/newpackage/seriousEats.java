package newpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class seriousEats {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();

		String baseUrl="https://www.seriouseats.com/";
		String expectedSearch="Chinese Herbal Silkie Chicken Soup Recipe";
		String actualSearch="";
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		WebElement searchIcon=driver.findElement(By.xpath("(//*[@class='icon icon-search-glass'])[2]"));
		WebElement searchInput=driver.findElement(By.id("search-box"));
		searchIcon.click();
		searchInput.sendKeys("Chinese Herbal Silkie Chicken Soup Recipe");
		searchInput.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		driver.close();
		
	}
}
