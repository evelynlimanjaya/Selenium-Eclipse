package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import PageFactory.backendPage;
import utility.constants;

public class day10Test {
	private WebDriver driver;
	private WebDriverWait wait;

	
	backendPage objBackendPage;

	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("testProfile");
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(myProfile);
		driver =  new FirefoxDriver(opt);
		wait=new WebDriverWait(driver,5);
		
		driver.get(constants.backendLoginURL);
		driver.manage().window().maximize();
	
	
	}
	
    @Test
    public void exportOrdersTest() throws InterruptedException {
    	Actions actions=new Actions(driver);
    	objBackendPage=new backendPage(driver);
    	objBackendPage.login();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'close')]")));
    	driver.findElement(By.xpath("//span[contains(text(),'close')]")).click();
    	WebElement salesTab=driver.findElement( By.xpath("//span[contains(text(),'Sales')]"));
    	actions.moveToElement(salesTab).perform();
    	WebElement ordersMenu=driver.findElement(By.xpath("//span[contains(text(),'Orders')]"));
    	ordersMenu.click();
    }
}
