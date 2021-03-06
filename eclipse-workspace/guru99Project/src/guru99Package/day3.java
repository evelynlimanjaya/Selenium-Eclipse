package guru99Package;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import readExcel.readGuru99Excel;

public class day3 {
	public static void main(String[] args) throws Exception {
		  
			  System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				WebDriverWait wait=new WebDriverWait(driver,5);
				
				String baseUrl = "http://www.demo.guru99.com/V4/";
				
				String actualBoxTitle;
				String titleText;
				
				driver.get(baseUrl);
				driver.manage().window().maximize();

				
				readGuru99Excel file=new readGuru99Excel();
				
				Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir"),"guru99Excel.xlsx" , "Sheet1");
//				int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
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
						actualBoxTitle = alt.getText(); // get content of the Alter Message
						alt.accept();
						if (actualBoxTitle.contains("User or Password is not valid")) { // Compare Error Text with Expected Error Value
						    System.out.println("Test case SS[" + i + "]: Passed"); 
						} else {
						    System.out.println("Test case SS[" + i + "]: Failed");
						}
					}    
				    catch (NoAlertPresentException Ex){ 
						WebElement titleSelector= driver.findElement(By.cssSelector("marquee[class='heading3']"));
//					wait.until(ExpectedConditions.visibilityOf(titleSelector));
						titleText=titleSelector.getText();
						// On Successful login compare Actual Page Title with Expected Title		
					if(titleText.equals("Welcome To Manager's Page of Guru99 Bank")) {
					    System.out.println("Test case SS[" + i + "]: Passed");
					} else {
					    System.out.println("Test case SS[" + i + "]: Failed");
					}
				    }
					driver.navigate().back();

				}
				
				driver.close();
			  
		  }

}
