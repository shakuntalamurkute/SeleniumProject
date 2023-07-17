package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputEdit {
	private static WebDriver driver;

	private static By workplace = By.id("testing");
	private static By inputClick = By.linkText("Edit");
	private static By fullNameInput = By.id("fullName");
	private static By joinInput = By.id("join");
	private static By getMeInput = By.id("getMe");
	private static By clearMeButton = By.id("clearMe");
	private By noEditElement = By.id("noEdit");
	private static By dontWriteInput = By.id("dontwrite");

	public InputEdit(WebDriver driver) {
		InputEdit.driver = driver;
	}

	public static By clickLink() {
		driver.findElement(workplace).click();
		driver.findElement(inputClick).click();
		driver.findElement(clearMeButton).clear();
		return clearMeButton;
	}

	public String enterFullName(String fullName) {
		driver.findElement(fullNameInput).sendKeys(fullName);
		return fullName;
	}

	public static void enterJoin(String text) {
		driver.findElement(joinInput).sendKeys(text, Keys.TAB);
	}

	public static String insideTextValue() {
		return driver.findElement(getMeInput).getAttribute("value");
	}

	public boolean isNoEditEnabled() {
		return driver.findElement(noEditElement).isEnabled();
	}

	public static String getDontWriteValue() {
		return driver.findElement(dontWriteInput).getAttribute("value");
	}

	public boolean isReadOnly() {
		return !driver.findElement(dontWriteInput).isEnabled();
	}

	public static By getJoinInput() {
		return By.id("join");
	}
}
