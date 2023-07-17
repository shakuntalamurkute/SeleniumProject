package test;

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

import Pagess.CustomDropDown;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class DropDownTest {

	WebDriver driver;
	CustomDropDown customDropdown;

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		new CustomDropDown(driver);
		driver.navigate().to("https://letcode.in/signin");

	}

	@Test(priority = -1)
	public void login() throws InterruptedException {

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

	@Test(priority = 1)
	public void testDropDown() {
		CustomDropDown.clickWorkspaceLink();
		CustomDropDown.clickDropdown();
		CustomDropDown.clickselectFruits("Banana");

		String selectedFruit = CustomDropDown.clickselectFruits("Banana");
		System.out.println("Selected fruit: " + selectedFruit);
		Assert.assertEquals("Banana", selectedFruit);
	}

	@Test(priority = 2)
	public void testhero() {
		CustomDropDown.clickWorkspaceLink();
		CustomDropDown.clickDropdown();

		String selectedHero = CustomDropDown.clickSelectedOptions("Iron Man");
		System.out.println("selected option:" + selectedHero);
		Assert.assertEquals("Iron Man", selectedHero);

	}

	@Test(priority = 3)
	public void testLang() {
		CustomDropDown.clickWorkspaceLink();
		CustomDropDown.clickDropdown();

		String selectedLanguage = CustomDropDown.clickLanguage("Java");
		System.out.println("Selected language: " + selectedLanguage);
		Assert.assertEquals("Java", selectedLanguage);

	}

	@Test(priority = 4)
	public void testcountry() {
		CustomDropDown.clickWorkspaceLink();
		CustomDropDown.clickDropdown();

		String selectedCountry = CustomDropDown.clickCountry("India");
		System.out.println("Selected country: " + selectedCountry);
		Assert.assertEquals("India", selectedCountry);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
