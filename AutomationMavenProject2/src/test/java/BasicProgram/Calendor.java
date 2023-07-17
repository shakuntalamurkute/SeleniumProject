package BasicProgram;

import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendor {
	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	static int currentDay = 0, currentMonth = 0, currentYear = 0;
	static int jumpToMonth = 0;
	static boolean increment = true;
	public static WebDriver driver;

	@BeforeClass
	public static void setup() {
		String dateToSet = "26/11/2023";

		getCurrentDateMonthAndYear();
		getTargetDateMonthAndYear(dateToSet);
		calculateHowManyMonthsToJump();

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
	}

	@Test
	public void selectDateInCalendar() {
		WebElement datePickerInput = driver.findElement(By.id("datepicker"));
		datePickerInput.click();

		// Wait until the calendar is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datepicker-calendar")));

		// Calculate the number of months to jump and navigate accordingly
		for (int i = 0; i < jumpToMonth; i++) {
			if (increment) {
				driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
			} else {
				driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w")).click();
			}
		}

		// Select the target day
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();

		// Verify that the selected date is displayed correctly
		String selectedDate = datePickerInput.getAttribute("value");
		String expectedDate = String.format("%02d/%02d/%04d", targetMonth, targetDay, targetYear);
		Assert.assertEquals(selectedDate, expectedDate,
				"Selected date is not displayed correctly. Expected: " + expectedDate + ", Actual: " + selectedDate);
		System.out.println(expectedDate);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	private static void calculateHowManyMonthsToJump() {
		if ((targetMonth - currentMonth) > 0) {
			jumpToMonth = targetMonth - currentMonth;
		} else {
			jumpToMonth = currentMonth - targetMonth;
			increment = false;
		}
	}

	public static void getTargetDateMonthAndYear(String dateToSet) {
		String[] dateParts = dateToSet.split("/");
		targetDay = Integer.parseInt(dateParts[0]);
		targetMonth = Integer.parseInt(dateParts[1]);
		targetYear = Integer.parseInt(dateParts[2]);
	}

	public static void getCurrentDateMonthAndYear() {
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);
	}
}