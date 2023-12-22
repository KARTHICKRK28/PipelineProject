package sampleExtentReport2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportTestNG3 {

	ExtentReports extent;
	ExtentTest test;
	String desc = "";
	String author = "";
	String Category = "";

	@BeforeSuite
	protected void StartReport() {
		// Blank html file
		// (./)-->root of the project
		ExtentSparkReporter report = new ExtentSparkReporter("./Testdatareport.html");

		// Actual report
		extent = new ExtentReports();
		extent.attachReporter(report);
	}

	@AfterSuite
	protected void StopReport() {
		extent.flush();
	}

	@BeforeClass
	void Initiatingtest() {
		test = extent.createTest(desc);
		test.assignAuthor(author);
		test.assignCategory(Category);
	}

	void stepreport(String status, String Description) {

		switch (status.toLowerCase()) {
		case "pass":
			test.pass(Description);
			break;
		case "fail":
			test.fail(Description);
			break;

		case "info":
			test.info(Description);
			break;

		case "warning":
			test.warning(Description);
			break;

		default:
			System.err.println("Status is not defined");
			break;
		}

	}

}
