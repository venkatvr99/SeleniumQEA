package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoWebShopPage {

	WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "Register")
	WebElement registerLink;
	@FindBy(how = How.LINK_TEXT, using = "Log in")
	WebElement loginLink;

	/**
	 * This Function returns the title of the Register Page
	 * 
	 * @return String
	 */
	public String clickRegister() {
		registerLink.click();
		return driver.getTitle();
	}

	public String clickLogin() {
		loginLink.click();
		return driver.getCurrentUrl();
	}

	public DemoWebShopPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
