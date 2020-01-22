package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest2 {

	@Test
	public void newTest2() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		WebElement from = driver.findElement(
				By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));

		WebElement to = driver.findElement(By.xpath("//div[contains(text(),'Price Checker')]"));

		Actions action = new Actions(driver);
//		action.clickAndHold(from).pause(2000).release(to).perform();
		action.dragAndDrop(from, to).pause(3000).perform();
		WebDriverWait webDriverWait = new WebDriverWait(driver,10);
		webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"),
				"Drop a package here to check price"));

		String text = driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker")).getText();
		System.out.println(text);
		driver.quit();

	}

}
