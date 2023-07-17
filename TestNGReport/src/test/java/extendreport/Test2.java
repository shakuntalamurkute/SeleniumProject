package extendreport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Test2 {
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass() {
		report = ExtendFactory.getInstance();
		test = report.createTest("Test2 Class -> Verification");
	}
	
	@Test
	public void testMethod() {
		test.log(Status.INFO, "Test2 -> testMethod Started...");
		test.log(Status.INFO, "Test2 -> testMethod Continuing...");
		test.log(Status.INFO, "Test2 -> testMethod End...");
	}

	@AfterClass
	public void afterClass() {
		
		report.flush();
	}
}