package BasicProgram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeypressClass {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		
		driver = new FirefoxDriver();
		baseUrl = "https://www.letskodeit.com/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testKeyPress() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		Thread.sleep(2000);
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("user_password")).sendKeys("123123");
		//Thread.sleep(2000);
		//driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}

	@AfterClass
	public void tearDown() throws Exception {
		// driver.quit();
	}
}


