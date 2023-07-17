package ExtendPageObjectReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class HomePage {

    private WebDriver driver;
    public ExtentTest test;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void clickSignUpLink() {
        WebElement signUpLink = driver.findElement(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a"));
        signUpLink.click();
        test.log(Status.INFO, "Clicked on signup link");
    }

    public void enterEmail(String email) {
        WebElement emailLink = driver.findElement(By.id("email"));
        emailLink.sendKeys(email);
        test.log(Status.INFO, "Enter email");
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("login-password"));
        passwordField.sendKeys(password);
        test.log(Status.INFO, "Enter password");
    }

    public void clickGoLink() {
        WebElement goButton = driver.findElement(By.id("login"));
        goButton.click();
        test.log(Status.INFO, "Clicked Go button");
    }

    public void login(String email, String password) {
        clickSignUpLink();
        enterEmail(email);
        enterPassword(password);
        clickGoLink();
    }
}