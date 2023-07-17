package BasicProgram;

import java.time.Duration;
import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        int year = 2019;
        int month = 12;
        int date = 10;
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        driver.findElement(By.id("datepicker")).click();
        while (true) {
            String monthyear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
            String arr[] = monthyear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            int currentYear = Integer.parseInt(yr);
            int currentMonth = Month.valueOf(mon.toUpperCase()).getValue();

            if (currentMonth == month && currentYear == year) {
                break;
            } else if (currentYear < year || (currentYear == year && currentMonth < month)) {
                driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
            } else {
                driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w")).click();
            }
        }
        driver.findElement(By.linkText(Integer.toString(date))).click();
    }
}