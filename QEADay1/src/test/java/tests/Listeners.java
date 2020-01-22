package tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test is started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is completed successfully");
	}
	

	public void onTestFailure(ITestResult result) {
		System.out.println("Test is failed");

	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test is failed with success percentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test failed due to timeout");
	}

	public void onStart(ITestContext context) {
		System.out.println("suite started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("suite finished");
	}

}
