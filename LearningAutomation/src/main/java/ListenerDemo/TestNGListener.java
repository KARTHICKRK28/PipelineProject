package ListenerDemo;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
	
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test cases failed and testcase details are :" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test cases skipped and testcase details are :" + result.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test cases started and testcase details are :" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test cases success and  testcase details are :" + result.getName());

	}

}
