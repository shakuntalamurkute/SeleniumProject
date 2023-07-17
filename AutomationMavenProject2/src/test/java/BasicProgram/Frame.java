package BasicProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		driver.manage().window().maximize();
		driver.switchTo().frame("firstFr");

		 WebElement firstNameInput = driver.findElement(By.name("fname"));
	        firstNameInput.sendKeys("Koushik");

	        WebElement lastNameInput = driver.findElement(By.name("lname"));
	        lastNameInput.sendKeys("Chatterje");

	        // Switch to the second frame
	        driver.switchTo().frame(1);

	        // Perform actions within the second frame
	        WebElement emailInput = driver.findElement(By.name("email"));
	        emailInput.sendKeys("mail@mail.com");

	        // Switch back to the default content
	        driver.switchTo().defaultContent();

	        // Click on the "Watch tutorial" button
	        WebElement watchTutorialButton = driver.findElement(By.linkText("Watch tutorial"));
	        watchTutorialButton.click();

		// driver.quit();

	}

}
