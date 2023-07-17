package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomAlert {
	static WebDriver driver;

	static By workplace = By.id("testing");
	static By alertDialog = By.linkText("Dialog");
	static By simpleAlertButton = By.id("accept");
	static By confirmButton = By.id("confirm");
	static By promptAlertButton = By.id("prompt");

	@SuppressWarnings("static-access")
	public CustomAlert(WebDriver driver) {
		this.driver = driver;
	}

	public static void clickWorkspaceAndAlertLink() {
		driver.findElement(workplace).click();
		driver.findElement(alertDialog).click();
	}

	public static String handleSimpleAlert() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.findElement(simpleAlertButton).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public static String handleConfirmButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.findElement(confirmButton).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		driver.findElement(confirmButton).click();
		alert.dismiss();
		return alertText;
	}

	public static String handlePromptButton(String value) {
		driver.findElement(promptAlertButton).click();
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.sendKeys(value);
		alert.accept();
		return driver.findElement(By.xpath("//p[@id='myName']")).getText();
	}

}