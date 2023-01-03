package Selenium.TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("SUCCESS");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILURE");
		
	}
}
