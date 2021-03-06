package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParallel {
	
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browserValue) {
		
		if(browserValue.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			}
		else {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			}
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test(dataProvider = "dp1")
	public void newTest4(String username, String password) {

		WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
		loginLink.click();

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.linkText("Log out")).click();
	}

	@DataProvider(name = "dp1")
	public Object[][] readData() {
		
		return ReadDataFromExcel.readDataFromExcel();
	}

	}
