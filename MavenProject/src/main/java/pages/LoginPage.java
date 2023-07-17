package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public static WebDriver driver;

	By emailInput = By.name("email");
	By passwordInput = By.name("password");
	By loginBtn = By.xpath("//button[text()='LOGIN']");

	@SuppressWarnings("static-access")
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void signIn(String email, String password) {
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginBtn).click();

	}

}
