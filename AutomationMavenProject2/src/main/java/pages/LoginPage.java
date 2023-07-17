package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver = null;
//	By signoutbtn= By.id("//a[text()='Sign out']");
	By loginBtn1 = By.xpath("//a[text()='Log in']");
	By emailInput = By.name("email");
	By passwordInput = By.name("password");
	By loginBtn = By.xpath("//button[text()='LOGIN']");
	
	


	public LoginPage(WebDriver d) // object of web driver
	{
		driver = d; // intialize the object
	}

	public void signIn(String email, String password) 
	{  
		//driver.findElement(signoutbtn).click();
		
		driver.findElement(loginBtn1).click();
		
		driver.findElement(emailInput).sendKeys(email);

		driver.findElement(passwordInput).sendKeys(password);

		driver.findElement(loginBtn).click();
		
		System.out.println("signin");
		
	
}
	

	
	
}