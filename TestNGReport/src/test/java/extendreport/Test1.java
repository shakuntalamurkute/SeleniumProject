package extendreport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Test1 {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "http://www.letskodeit.com/";
		report = new ExtentReports();
		report = ExtendFactory.getInstance();
		test = report.createTest("Verify Welcome Text");
		driver = new ChromeDriver();
		test.log(Status.INFO, "Browser Started...");
		driver.manage().window().maximize();
		test.log(Status.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
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
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		
		report.flush();
	}
}
