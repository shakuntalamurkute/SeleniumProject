package BasicProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/windows");
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();  // getwindow handle wrtten the set of string
		driver.switchTo().window("");
		List<String> list = new ArrayList<String>(windowHandles);
		for(String winId:list)
		{
			System.out.println(winId);        // show the id of the 
		}
		int size = list.size();
		System.out.println("No of windows" +size);
		driver.switchTo().window(list.get(1));  //get size is always 0 or 1 0 means parent main window and 1 is the current open window 
		driver.findElement(By.linkText("Product")).click();
		
		driver.close();
		
		
}
}
