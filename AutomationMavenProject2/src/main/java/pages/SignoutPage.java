package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignoutPage
{  
	public static WebDriver driver = null;
	By signoutbtn= By.id("//a[text()='Sign out']");
  
	public SignoutPage(WebDriver d) // object of a webdriver
	{
		driver = d; // Initilize the object
	}


public void signout()
{
	driver.findElement(signoutbtn).click();
}
}