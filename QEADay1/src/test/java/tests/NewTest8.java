package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DemoWebShopLoginPage;
import pages.DemoWebShopPage;
import pages.DemoWebShopRegisterPage;

public class NewTest8 {

	WebDriver driver;
	DemoWebShopPage welcomePage;
	DemoWebShopLoginPage loginPage;
	DemoWebShopRegisterPage registerPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		welcomePage = PageFactory.initElements(driver, DemoWebShopPage.class);
		loginPage = PageFactory.initElements(driver, DemoWebShopLoginPage.class);
		registerPage = PageFactory.initElements(driver, DemoWebShopRegisterPage.class);

	}

	@AfterTest
	public void afterTest() {
		welcomePage = null;
		loginPage = null;
		registerPage = null;
	}

	@Test
	public void testLogin() {
		String clickLogin = welcomePage.clickLogin();
		boolean loginButtonClick = loginPage.loginButtonClick();
	}

	@Test
	public void testLoginButton() {
		boolean logoutexists = loginPage.loginButtonClick();
		Assert.assertTrue(logoutexists);
	}
}
