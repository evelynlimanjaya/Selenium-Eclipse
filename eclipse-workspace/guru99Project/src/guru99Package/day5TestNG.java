package guru99Package;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import readExcel.readGuru99Excel;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

public class day5TestNG {
	public String baseUrl = "http://www.demo.guru99.com/V4/";
	public WebDriver driver;
	public WebDriverWait wait;
	
//	@DataProvider (name="loginProvider")
//	public Object[][]getDataFromDataProvider(){
//		
//	}
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("testProfile");
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(myProfile);
		driver =  new FirefoxDriver(opt);
		wait=new WebDriverWait(driver,5);
		

		
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}
	

	
	@Test
	public void loginTest() throws Exception {		
		String actualBoxTitle;
		String welcomeText;
		
		readGuru99Excel file=new readGuru99Excel();
		
		Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir"),"guru99Excel.xlsx" , "Sheet1");
//		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
		for(int i=1;i<5;i++) {
			WebElement UserID=driver.findElement(By.cssSelector("[name='uid']"));
			WebElement Password=driver.findElement(By.cssSelector("[name='password']"));
			WebElement Login=driver.findElement(By.cssSelector("[name='btnLogin']"));
			Row row = guru99Sheet.getRow(i);

			UserID.sendKeys(row.getCell(0).getStringCellValue());
			Password.sendKeys(row.getCell(1).getStringCellValue());
			Login.click();
			
			try{ 
			    
		       	Alert alt = driver.switchTo().alert();
				actualBoxTitle = alt.getText(); // get content of the Alert Message
				alt.accept();
				if (actualBoxTitle.contains("User or Password is not valid")) { // Compare Error Text with Expected Error Value
				    System.out.println("Test case SS[" + i + "]: Passed"); 
				} 
				else {
				    System.out.println("Test case SS[" + i + "]: Failed");
				}
			}    
		    catch (NoAlertPresentException Ex){ 
		    	WebElement welcomeMsg=driver.findElement(By.cssSelector("tr[class='heading3']"));
//				wait.until(ExpectedConditions.visibilityOf(titleSelector));
				welcomeText=welcomeMsg.getText();
				// On Successful login compare Actual Welcome Message with Expected Welcome Message		
				if(welcomeText.equals("Manger Id : mngr293142")) {
					System.out.println("Test Case: Passed");
				}
				else {
					System.out.println("Test Case: Failed");
				}
		    }
			driver.navigate().back();

		}
		

	  
  }
	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
