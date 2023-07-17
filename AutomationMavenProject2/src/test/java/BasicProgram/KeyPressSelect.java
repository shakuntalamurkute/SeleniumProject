package BasicProgram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyPressSelect {
	private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testKeyPress() throws Exception {
        driver.get(baseUrl);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL+ "a");
        
        //String selectAll = Keys.chord(Keys.COMMAND, "a");
		//driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		//Thread.sleep(2000);
        
    }

    @AfterClass
    public void tearDown() throws Exception {
       driver.quit();
    }
}

