package fileUplodWindow;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadAutoIt {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseUrl = "https://www.gmail.com/";
		driver = new ChromeDriver();
		;

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void fileUpload() throws AWTException, InterruptedException, IOException {
		driver.findElement(By.id("identifierId")).sendKeys("shakuntala.murkute@vshsolutions.com");

		driver.findElement(By.id("identifierNext")).click();

		driver.findElement(By.name("Passwd")).sendKeys("Shanu@123");

		driver.findElement(By.id("passwordNext")).click();

		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();

		driver.findElement(By.xpath("//div[@aria-label='Search Field']/div/input"))
				.sendKeys("sonalmurkute1998@gmail.com");

		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");

		WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));

		// Execute JavaScript to click the file input element
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", fileInput);

		Runtime.getRuntime().exec("C:\\Users\\lenovo\\Desktop\\AutoIt\\FileUplod2.exe");

	}

	@AfterClass
	public void afterClass() {
	}

}