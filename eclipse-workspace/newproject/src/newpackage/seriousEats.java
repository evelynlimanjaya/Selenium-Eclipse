package newpackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class seriousEats {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		String baseUrl="https://www.seriouseats.com/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}
}
