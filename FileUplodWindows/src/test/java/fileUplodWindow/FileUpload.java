package fileUplodWindow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        baseUrl = "https://www.monsterindia.com/";
        driver = new ChromeDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get(baseUrl);
    }

    @Test
    public void fileUploadWebsite() throws AWTException {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"heroSection-container\"]/div[3]/div[2]/div[2]"));
        button.click();

     // Wait for the "select file" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload")));

        // Click the button using JavaScript executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", button1);
       

		StringSelection ss = new StringSelection("C:\\Users\\lenovo\\Desktop\\TestFile.txt");
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
        
        
        
        
    }
}