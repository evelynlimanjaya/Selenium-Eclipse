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
	
	
}
