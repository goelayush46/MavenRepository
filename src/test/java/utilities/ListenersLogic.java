package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersLogic implements ITestListener{
	
	public static WebDriver driver;
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test Case is Passed");
		ScreenshotUtil.screenshot(driver, result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		Reporter.log("Test Case is Failed");
		ScreenshotUtil.screenshot(driver, result.getName());
	}
}
