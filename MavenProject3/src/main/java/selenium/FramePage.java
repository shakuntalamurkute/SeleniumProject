package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramePage {
    private ChromeDriver driver;
    private By firstNameInput = By.name("fname");
    private By lastNameInput = By.name("lname");
    private By emailInput = By.name("email");
    private By watchTutorialButton = By.linkText("Watch tutorial");

    public FramePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void switchToFirstFrame() {
        driver.switchTo().frame("firstFr");
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameInput);
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameInput);
        lastNameElement.sendKeys(lastName);
    }

    public void switchToSecondFrame() {
        driver.switchTo().frame(1);
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.sendKeys(email);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void clickWatchTutorialButton() {
        WebElement tutorialButton = driver.findElement(watchTutorialButton);
        tutorialButton.click();
    }
}