package ExtendPageObjectModelReport;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtendPageObjectReport.HomePage;

public class LoginTest {	

	private WebDriver driver;
	private String baseUrl;
	private ExtentReports report;
	private ExtentTest test;
	private HomePage hp;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "http://www.letskodeit.com/";
		report = new ExtentReports();

		test = report.createTest("Verify Welcome Text");
		driver = new ChromeDriver();
		hp = new HomePage(driver, test);
		hp.test = test;
		test.log(Status.INFO, "Browser Started...");
		driver.manage().window().maximize();
		test.log(Status.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
		test.log(Status.INFO, "Web application opened");
	}

	@Test
	public void test1_validLoginTest() throws Exception {
		hp.login("test@email.com", "abcabc");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		report.flush();
	}
}