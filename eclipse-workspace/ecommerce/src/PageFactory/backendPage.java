package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class backendPage {
	WebDriver driver;
	@FindBy(name="login[username]")
	WebElement usernameInput;
	@FindBy(name="login[password]")
	WebElement passInput;
	
	public backendPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}
