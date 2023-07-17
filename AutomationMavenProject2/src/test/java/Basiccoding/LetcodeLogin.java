package Basiccoding;

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

public class LetcodeLogin {
    @Test
    public void LoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://letcode.in/signin");

        WebElement user = driver.findElement(By.name("email"));
        user.sendKeys("shakuntalamurkute510@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Shanu@123");

        WebElement button = driver.findElement(By.xpath("//button[text()='LOGIN']"));
        button.click();
        
       // By newCourseBtn = By.xpath("//a[text()='New Course!']");
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(newCourseBtn));

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://letcode.in/";
		Assert.assertEquals(actualUrl, expectedUrl);
	}

     
        //driver.quit();
    }
  