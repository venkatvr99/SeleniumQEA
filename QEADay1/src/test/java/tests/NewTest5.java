package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest5 {
	@Test
	public void newtest5() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("popupBoxClose")).click();
		WebElement prodType = driver.findElement(By.xpath("//li[contains(text(),'Deposits')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", new Object[] { prodType });
		js.executeScript("window.scrollBy(0,2000)");
		driver.quit();
	}

}
