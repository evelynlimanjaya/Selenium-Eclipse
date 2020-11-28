package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class webElements {
	WebDriver driver;
	By accountIcon=By.cssSelector("[class='skip-link skip-account']");
	By myAccount=By.cssSelector("[title='My Account']");
	By emailLogin=By.id("email");
	By passLogin=By.id("pass");
	By loginBtn=By.id("send2");
	By wishlist=By.xpath("//a[contains(text(),'My Wishlist')]");
	By addToCart=By.cssSelector("[title='Add to Cart']");
	By checkout=By.cssSelector("[title='Proceed to Checkout']");
	
}
