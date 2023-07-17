package fileUplodWindow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class FileUplodWindow {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void SetUp() throws MalformedURLException {
		baseUrl = "https://www.gmail.com/";
		driver = new ChromeDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(baseUrl);
	}

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

		StringSelection ss = new StringSelection("C:\\Users\\lenovo\\Desktop\\Marksheet BE.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.setAutoDelay(2000);

		// Press Ctrl+V to paste the file path
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);

		// Press Enter to confirm the file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
