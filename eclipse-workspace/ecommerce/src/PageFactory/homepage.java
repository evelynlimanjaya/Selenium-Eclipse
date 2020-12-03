package PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class homepage {
	WebDriver driver;
	@FindBy(className="skip-link skip-account")
	WebElement accountIcon;
	@FindBy(css="[title='My Account']")
	WebElement myAccount;
	@FindBy(css="#email")
	WebElement emailLogin;
	@FindBy(css="#pass")
	WebElement passLogin;
	@FindBy(css="#send2")
	WebElement loginBtn;
	
	
}
