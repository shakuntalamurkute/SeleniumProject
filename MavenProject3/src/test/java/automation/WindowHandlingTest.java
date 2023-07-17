package automation;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import windows.WindowsHandling;

public class WindowHandlingTest {
    private WebDriver driver;
    private WindowsHandling windowsHandling;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/windows");
        windowsHandling = new WindowsHandling(driver);
    }

    @Test
    public void windowHandlingTest() {
        windowsHandling.clickHomeLink();

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        System.out.println("Window Handles:");
        for (String winId : windowHandlesList) {
            System.out.println(winId);
        }

        int size = windowHandlesList.size();
        System.out.println("No of windows: " + size);

        driver.switchTo().window(windowHandlesList.get(1));
        windowsHandling.clickProductLink();
        
        String expectedTitle = "LetXPath - XPath tool";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle, "Incorrect page title");
        System.out.println("page Title:  "+expectedTitle);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}