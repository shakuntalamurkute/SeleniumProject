package BasicProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sort {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();


    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://jqueryui.com/sortable/");
   // WebElement clicksort=driver.findElement(By.linkText("Sortable"));
    //clicksort.click();
    
    driver.switchTo().frame(0);
    WebElement sort1=driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
    WebElement sort2=driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[3]"));
    
    Actions act=new Actions(driver);
    act.dragAndDrop(sort1, sort2).build().perform();
}
}
