package runnerTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.SignupPage;

public class LoginTest {

	// private Object wait;

	@Test
	public void login() throws InterruptedException {

// launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		 SignupPage signupPage = new SignupPage(driver);
		driver.get("https://letcode.in/signup");

		signupPage.signUp("vi", "skuntala@gmail.com", "anu@123");
		By newcoursebtn = By.xpath("//a[text()='New Course!']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(newcoursebtn));

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl1 = "https://letcode.in/";
		Assert.assertEquals(actualUrl, expectedUrl1);
		System.out.println(actualUrl);

		LoginPage loginpage = new LoginPage(driver);
		driver.navigate().to("https://letcode.in/signin");

		loginpage.signIn("shakuntalamurkute510@gmail.com", "Shanu@123");

		//By newcoursebtn1 = By.xpath("//a[text()='New Course!']");
		//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		//WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(newcoursebtn1));

		String actualUrl1 = driver.getCurrentUrl();

	    System.out.println(actualUrl1);

		String expectedUrl11 = "https://letcode.in/";
		Assert.assertEquals(actualUrl1, expectedUrl11);

		driver.quit();
	}

}
