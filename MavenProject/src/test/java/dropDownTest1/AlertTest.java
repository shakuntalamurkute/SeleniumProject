package dropDownTest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CustomAlert;
import pages.LoginPage;

public class AlertTest {
	WebDriver driver;
	CustomAlert customAlert;

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		customAlert = new CustomAlert(driver);
		driver.navigate().to("https://letcode.in/signin");

	}

	@Test(priority = -1, description = "Smoke Test: Verify successful login")
	public void login() throws InterruptedException {

		LoginPage loginpage = new LoginPage(driver);
		driver.navigate().to("https://letcode.in/signin");

		loginpage.signIn("shakuntalamurkute510@gmail.com", "Shanu@123");
		By newcoursebtn1 = By.xpath("//a[text()='New Course!']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(newcoursebtn1));

		String actualUrl11 = driver.getCurrentUrl();

		System.out.println(actualUrl11);

		String expectedUrl = "https://letcode.in/";
		Assert.assertEquals(actualUrl11, expectedUrl);

	}

	@Test(priority = 2, description = "Sanity Test: Verify simple alert functionality")
	public void testSimpleAlert() throws InterruptedException {

		CustomAlert.clickWorkspaceAndAlertLink();
		String simpleAlertText = CustomAlert.handleSimpleAlert();

		System.out.println(simpleAlertText);
		Assert.assertEquals("Hey! Welcome to LetCode", simpleAlertText);
	}

	@Test(priority = 3, description = "Sanity Test: Verify confirm button functionality")

	public void testConfirmButton() throws InterruptedException {
		CustomAlert.clickWorkspaceAndAlertLink();
		String confirmText = CustomAlert.handleConfirmButton();

		System.out.println(confirmText);
		Assert.assertEquals("Are you happy with LetCode?", confirmText);
	}

	@Test(priority = 4, description = "Sanity Test: Verify prompt button functionality")
	public void testPromptButton() {
		CustomAlert.clickWorkspaceAndAlertLink();
		String promptResult = CustomAlert.handlePromptButton("automation");

		System.out.println(promptResult);
		Assert.assertEquals("Your name is: automation", promptResult);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
