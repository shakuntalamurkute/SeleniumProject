package testclasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class LoginTestWithScreenshot {

	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void setUp() {
		baseUrl = "http://www.letskodeit.com/";
		report = new ExtentReports();

		test = report.createTest("Verify Welcome Text");
		driver = new ChromeDriver();
		test.log(Status.INFO, "Browser Started...");
		driver.manage().window().maximize();
		test.log(Status.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
		test.log(Status.INFO, "Web application opened");
	}

	@Test
	public void test1_validLoginTest() throws Exception {
		WebElement signinLink = driver.findElement(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a"));
		signinLink.click();
		test.log(Status.INFO, "Clicked on signIn link");

		WebElement emailLink = driver.findElement(By.id("email"));
		emailLink.sendKeys("test@email.com");
		test.log(Status.INFO, "Enter email");

		WebElement passwordField = driver.findElement(By.id("login-password"));
		passwordField.sendKeys("abcabc");
		test.log(Status.INFO, "Enter password");

		WebElement goButton = driver.findElement(By.id("login"));
		goButton.click();
		test.log(Status.INFO, "Clicked Go button");

	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			// Capture screenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Define destination path for the screenshot
			String destinationPath = "C:\\Users\\lenovo\\eclipse-workspace\\New WorkSpace\\TestNGReport\\Screenshot\\ElementPage.png";
			File destinationFile = new File(destinationPath);

			// Save the screenshot to the destination path
			FileUtils.copyFile(sourceFile, destinationFile);

			// Add the screenshot to the ExtentReport
			test.log(Status.FAIL, "Verify Welcome Text Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(destinationPath).build());
		}

		driver.quit();
		report.flush();
	}
}