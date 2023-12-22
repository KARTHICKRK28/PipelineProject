package sampleExtentReport2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportPreparation {

	public static void main(String[] args) {

		// Blank html file
		// (./)-->root of the project
		ExtentSparkReporter report = new ExtentSparkReporter("C:\\Users\\karthick.r\\Videos\\Testreport.html");

		// Actual report
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(report);

		ExtentTest test1 = extend.createTest("TC001_ Search product");
		test1.assignAuthor("Karthick");
		test1.assignCategory("Regression");
		test1.pass("Enter the desired product name");
		test1.pass("Check if the product is listed");
		test1.pass("Add the product to the cart");

		ExtentTest test2 = extend.createTest("TC002_ Making Payment");
		test2.assignAuthor("Krithika");
		test2.assignCategory("Regression");
		test2.pass("Navigated to the payment page");
		test2.fail("Payment got failed",
				MediaEntityBuilder.createScreenCaptureFromPath("failed.png").build());

		// Last
		extend.flush();
		System.out.println("Products are listed and added Successfully");

	}
}
