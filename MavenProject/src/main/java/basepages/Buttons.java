package basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons {
	static WebDriver driver;
	static By workplace = By.id("testing");

	static By buttonClick = By.linkText("Click");
	static By homeClick = By.id("home");

	public Buttons(WebDriver driver) {
		Buttons.driver = driver;
	}

	public static boolean clickLink() {
		driver.findElement(workplace).click();
		driver.findElement(buttonClick).click();
		 return driver.findElement(homeClick).isDisplayed();

	}

}
