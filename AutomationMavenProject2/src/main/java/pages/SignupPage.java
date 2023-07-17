package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {


	public static WebDriver driver = null;
	By nameInput = By.id("name");
	By emailInput1 = By.name("email");
	By pwdInput = By.name("password");
	By checkBox = By.id("agree");
	By signupBtn = By.xpath("//button[text()='SIGN UP']");
	//By signoutbtn= By.id("//a[text()='Sign out']");
	
	//By loginBtn1 = By.xpath("//a[text()='Log in']");
	
// constructor
	public SignupPage(WebDriver d) // object of a webdriver
	{
		driver = d; // Initilize the object
	}

	public void signUp(String name, String email,String password) {
		
		driver.findElement(nameInput).sendKeys(name);

       
		driver.findElement(emailInput1).sendKeys(email);

		driver.findElement(pwdInput).sendKeys(password);

		driver.findElement(checkBox).click();

		driver.findElement(signupBtn).click();
		
		//driver.findElement(loginBtn1).click();
		 
	}

			
	}
		
	
