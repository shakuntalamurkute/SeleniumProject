
package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openDatePickerDemo() {
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
    }

    public void selectDate(String dateToSet) {
        WebElement datePickerInput = driver.findElement(By.id("datepicker"));
        datePickerInput.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datepicker-calendar")));

        int targetDay = 0, targetMonth = 0, targetYear = 0;
        String[] dateParts = dateToSet.split("/");
        targetDay = Integer.parseInt(dateParts[0]);
        targetMonth = Integer.parseInt(dateParts[1]);
        targetYear = Integer.parseInt(dateParts[2]);

        navigateToTargetMonth(targetMonth);
        selectTargetDay(targetDay);
    }

    private void navigateToTargetMonth(int targetMonth) {
        int currentMonth = getCurrentMonth();
        int jumpToMonth = Math.abs(targetMonth - currentMonth);

        for (int i = 0; i < jumpToMonth; i++) {
            if (targetMonth > currentMonth) {
                driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
            } else {
                driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w")).click();
            }
        }
    }

    private void selectTargetDay(int targetDay) {
        driver.findElement(By.linkText(Integer.toString(targetDay))).click();
    }

    private int getCurrentMonth() {
        return Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-month")).getAttribute("data-month"))
                + 1;
    }
}