package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class backendPage {
	private String backendID="user01";
	private String backendPass="guru99com";
	
	WebDriver driver;
	@FindBy(name="login[username]")
	WebElement usernameInput;
	@FindBy(name="login[password]")
	WebElement passInput;
	@FindBy(css="[title='Login']")
	WebElement loginBtn;
	
	
	public backendPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void login() {
		usernameInput.sendKeys(backendID);
		passInput.sendKeys(backendPass);
		loginBtn.click();
		driver.switchTo().alert().dismiss();
	}
}
