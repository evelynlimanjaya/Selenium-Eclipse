package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class seriousEats {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		String baseUrl="https://www.seriouseats.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[@class='icon icon-search-glass'])[2]")).click();
		Thread.sleep(10000);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
		
	}
}
