package basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Basepage {

	public static WebDriver driver;

	By emailInput = By.name("email");
	By passwordInput = By.name("password");
	By loginBtn = By.xpath("//button[text()='LOGIN']");

	public void LoginPage(WebDriver driver) {
		Basepage.driver = driver;
	}

	public void signIn(String email, String password) {
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginBtn).click();

	}

}
