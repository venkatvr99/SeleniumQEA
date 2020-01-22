package tests;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest3 {

	@Test
	public void newTest3() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		WebElement from = driver.findElement(By.id("FromTag"));
		from.sendKeys("Chenn");
		WebDriverWait wait=new WebDriverWait(driver,10);
		List<WebElement> list = from.findElements(By.tagName("ul"));
		for (WebElement webElement : list) {

			if (webElement.getText().contains("MAA"))
				webElement.click();
		}

		WebElement to = driver.findElement(By.id("ToTag"));
		to.sendKeys("HYD");
		List<WebElement> list2 = to.findElements(By.tagName("ul"));
		for (WebElement list1 : list2) {
			if (list1.getText().contains("HYD"))
				list1.click();

		}
	}
}
