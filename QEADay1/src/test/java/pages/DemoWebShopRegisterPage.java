package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoWebShopRegisterPage {

	WebDriver driver;

	WebElement gender;
	WebElement firstName;
	WebElement lastName;
	WebElement email;
	WebElement password;
	WebElement confirmPassword;
	WebElement register;

	public void clickRegister() {

	}

	public DemoWebShopRegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
}
