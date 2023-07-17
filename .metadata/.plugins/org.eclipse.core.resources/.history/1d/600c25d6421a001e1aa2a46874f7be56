package BasicProgram;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotParticularSection {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/dropable");
		
		WebElement section=driver.findElement(By.xpath("//div[@id='draggable']"));

		File src = section.getScreenshotAs(OutputType.FILE);
		
		File destination=new File("C:\\Users\\lenovo\\eclipse-workspace\\New WorkSpace\\AutomationMavenProject2\\Screenshot\\SectionPage.png");
		
			FileUtils.copyFile(src, destination);
}
	
}
