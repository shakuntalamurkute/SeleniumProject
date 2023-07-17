package BasicProgram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {
	static WebDriver driver;
	FirefoxOptions ff = new FirefoxOptions();

	@BeforeTest
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(ff);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/slider/");

	}

	@Test
	public void testslider() {
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement mainSlider = driver.findElement(By.id("slider"));

		int width = mainSlider.getSize().getWidth() / 2;
		WebElement slider = driver.findElement(By.cssSelector(".ui-slider-handle"));

		new Actions(driver).dragAndDropBy(slider, width, 0).perform();
	}

	//@AfterClass
	//public static void tearDown() {
		//driver.quit();
	}


