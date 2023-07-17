package BasicProgram;


	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver.Navigation;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class ButtonNavigation {


		public static void main(String[]args) throws InterruptedException 
		{
		ChromeDriver driver = new ChromeDriver();
		
		Navigation navigate=driver.navigate();
		
		navigate.to("https://letcode.in/buttons");
		System.out.println("Buttons:"+driver.getCurrentUrl());
		
		
		driver.findElement(By.id("home")).click();
		System.out.println("letcode.in:"+driver.getCurrentUrl());
		navigate.back();
		
		System.out.println("Buttons:"+driver.getCurrentUrl());
		
		new WebDriverWait(driver, Duration.ofSeconds(20));
		navigate.forward();
		
		System.out.println("letcode.in:"+driver.getCurrentUrl());
		new WebDriverWait(driver, Duration.ofSeconds(20));
		navigate.refresh();
		
		}
	}

