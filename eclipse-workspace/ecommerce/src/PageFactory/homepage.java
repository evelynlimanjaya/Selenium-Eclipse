package PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class homepage {
	WebDriver driver;
	@FindBy(css="[class='skip-link skip-account']")
	WebElement accountIcon;
	@FindBy(css="[title='My Account']")
	WebElement myAccount;
	@FindBy(css="#email")
	WebElement emailLogin;
	@FindBy(css="#pass")
	WebElement passLogin;
	@FindBy(css="#send2")
	WebElement loginBtn;
	@FindBy(xpath="//a[contains(text(),'My Wishlist')]")
	WebElement wishlist;
	@FindBy(css="[title='Add to Cart']")
	WebElement addToCart;
	@FindBy(css="[title='Proceed to Checkout']")
	WebElement checkout;
	@FindBy(css="[class='level0 nav-1 first']")
	WebElement mobileMenu;
	
	public homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void accessMyAccountTest() {
		accountIcon.click();
		myAccount.click();
	}
	
	public void loginTest() {
		emailLogin.clear();
		emailLogin.sendKeys("crimson.eve@gmail.com");
		passLogin.clear();
		passLogin.sendKeys("bobamilktea");
		loginBtn.click();
	}
	
	public void addToCartTest() {
		accountIcon.click();
		wishlist.click();
		addToCart.click();
		checkout.click();
	}
	
	public void accessMobileMenu() {
		mobileMenu.click();
	}
	
}
