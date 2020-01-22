package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class NewTest1 {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("popupBoxClose")).click();
		Actions action = new Actions(driver);
		WebElement paylink = driver.findElement(By.xpath("//span[text()='PAY']"));
		action.moveToElement(paylink).pause(3000).perform();
		driver.findElement(By.xpath("//a[@href='/personal/pay/cards/credit-cards']")).click();
		String title = driver.getTitle();
		Assert.assertTrue(title.startsWith("Credit Card"));
		driver.quit();
	}
}
