package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsHandling {
	private WebDriver driver;

	public WindowsHandling(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHomeLink() {
		driver.findElement(By.id("home")).click();
	}

	public void clickProductLink() {
		driver.findElement(By.linkText("Product")).click();
	}
}
