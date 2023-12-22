package sampleExtentReport2;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends ExtendReportTestNG3 {

	@BeforeTest
	void SetInputData() {
		desc = "First Test";
		author = "Karthick";
		author = "Monish";
		Category = "Sanity";
	}

	@Test(priority = 1)
	void MyTest1() {

		System.out.println("Test Started");
		stepreport("pass", "Test Execution");

		stepreport("warning", "Test Execution");
		stepreport("fail", "Test Execution");
		System.out.println("Test Ended");
	}

	@Test(priority = 0)
	void MyTest2() {

		System.out.println("Test Begins");
		stepreport("info", "Test Execution for Case 2");

		System.out.println("Test Ends");
	}
}
