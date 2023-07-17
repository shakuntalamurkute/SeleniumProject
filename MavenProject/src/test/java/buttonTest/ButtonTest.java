package buttonTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepages.Buttons;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class ButtonTest {
	WebDriver driver;
	Buttons customButton;

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://letcode.in/");
		customButton = new Buttons(driver);

	}

	@Test(description = "Smoke Test: Verify successful login")
	public void login() {

		LoginPage loginpage = new LoginPage(driver);
		driver.navigate().to("https://letcode.in/signin");

		loginpage.signIn("shakuntalamurkute510@gmail.com", "Shanu@123");
		By newcoursebtn1 = By.xpath("//a[text()='New Course!']");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(newcoursebtn1));

		String actualUrl11 = driver.getCurrentUrl();

		System.out.println(actualUrl11);

		String expectedUrl = "https://letcode.in/";
		Assert.assertEquals(actualUrl11, expectedUrl);

	}

	@Test(description = "Smoke Test: Verify home page display")
	public void testButton() {
		Buttons.clickLink();
		boolean isHomePageDisplayed = Buttons.clickLink();

		Assert.assertTrue(isHomePageDisplayed, "Button click operation failed. Home page not displayed.");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}