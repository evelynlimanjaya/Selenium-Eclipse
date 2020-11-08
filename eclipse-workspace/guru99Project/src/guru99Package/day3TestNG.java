package guru99Package;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import readExcel.readGuru99Excel;
import org.testng.annotations.Test;

public class day3TestNG {
  @Test
  public void loginTest() throws Exception {
	  System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver,5);
		
		String baseUrl = "http://www.demo.guru99.com/V4/";
		
		driver.get(baseUrl);
		driver.manage().window().maximize();

		
		readGuru99Excel file=new readGuru99Excel();
		
		Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir"),"guru99Excel.xlsx" , "Sheet1");
//		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
		for(int i=1;i<4;i++) {
			WebElement UserID=driver.findElement(By.cssSelector("[name='uid']"));
			WebElement Password=driver.findElement(By.cssSelector("[name='password']"));
			WebElement Login=driver.findElement(By.cssSelector("[name='btnLogin']"));
			Row row = guru99Sheet.getRow(i);

			UserID.sendKeys(row.getCell(0).getStringCellValue());
			Password.sendKeys(row.getCell(1).getStringCellValue());
			Login.click();
			WebElement titleSelector= driver.findElement(By.cssSelector("marquee[class='heading3']"));
////		wait.until(ExpectedConditions.visibilityOf(titleSelector));
			String titleText=titleSelector.getText();
		
			if(titleText.equals("Welcome To Manager's Page of Guru99 Bank")) {
			System.out.print("Test Passed");
			}
			else {
			System.out.print("Test Failed");
			}
			driver.navigate().back();

		}
		
//		 System.out.print(row.getCell(0).getStringCellValue()+"|| ");
		

//		

//		
//		WebElement titleSelector= driver.findElement(By.cssSelector("marquee[class='heading3']"));
////		wait.until(ExpectedConditions.visibilityOf(titleSelector));
//		String titleText=titleSelector.getText();
//		
//		if(titleText.equals("Welcome To Manager's Page of Guru99 Bank")) {
//			System.out.print("Test Passed");
//		}
//		else {
//			System.out.print("Test Failed");
//		}
		
		driver.close();
	  
  }
}
