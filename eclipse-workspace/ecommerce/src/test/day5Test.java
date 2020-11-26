package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.constants;

public class day5Test {
	public WebDriver driver;
	public WebDriverWait wait;
	public String firstName = "Evelyn";
	public String lastName="Limanjaya";
	public String email="crimson.eve@gmail.com";
	public String password ="bobamilktea";
	public String confirmPass="bobamilktea";
	
	
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("testProfile");
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(myProfile);
		driver =  new FirefoxDriver(opt);
		wait=new WebDriverWait(driver,5);
		
		driver.get(constants.URL);
		driver.manage().window().maximize();
	
	
	}
	
	@Test
	public void createAccount() {
		WebElement accountIcon=driver.findElement(By.cssSelector("[class='skip-link skip-account']"));
		accountIcon.click();
		WebElement myAccount=driver.findElement(By.cssSelector("[title='My Account']"));
		myAccount.click();
		WebElement createAccount=driver.findElement(By.cssSelector("[title='Create an Account']"));
		createAccount.click();
		WebElement firstNameField=driver.findElement(By.id("firstname"));
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		WebElement lastNameField=driver.findElement(By.id("lastname"));
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
		WebElement emailField=driver.findElement(By.id("email_address"));
		emailField.clear();
		emailField.sendKeys(email);
		WebElement passwordField=driver.findElement(By.id("password"));
		passwordField.clear();
		passwordField.sendKeys(password);
		WebElement confirmField=driver.findElement(By.id("confirmation"));
		confirmField.clear();
		confirmField.sendKeys(confirmPass);
		
	}
}
