package testclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Trial {
	private WebDriver driver;
	private String baseUrl;
     
	@BeforeClass
	public void beforeClass() {
		baseUrl = "http://www.letskodeit.com/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@Test
	public void testMethod() {
		driver.get(baseUrl); // Navigate to the specified URL
		// Your test code goes here
		// ...
	}
}