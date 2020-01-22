package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest tests;

	@BeforeTest
	public void beforeTest() {

		SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss-ms");
		String filePath = System.getProperty("user.dir") + "/ExtentReports/" + date.format(new Date()) + ".html";
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		htmlReporter = new ExtentHtmlReporter(filePath);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		tests = report.createTest(result.getMethod().getMethodName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			String descFile = System.getProperty("user.dir") + "/ExtentReports/screenshots/"
					+ result.getMethod().getMethodName() + ".png";
			try {
				FileUtils.copyFile(srcFile, new File(descFile));
				tests.log(Status.PASS, result.getMethod().getMethodName());
				tests.addScreenCaptureFromPath(descFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			String descFile = System.getProperty("user.dir") + "/ExtentReports/screenshots/"
					+ result.getMethod().getMethodName() + ".png";
			try {
				FileUtils.copyFile(srcFile, new File(descFile));
				tests.log(Status.FAIL, result.getMethod().getMethodName());
				tests.addScreenCaptureFromPath(descFile);
				tests.log(Status.FAIL, result.getThrowable().getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@AfterTest
	public void afterTest() {
		report.flush();
		driver.close();
	}

	@Test
	public void test() {
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
		loginLink.click();

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("askemail@email.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.linkText("Log out")).click();
	}

}
