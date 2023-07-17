package BasicProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Multipleselect {
	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/selectable/");
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement element1=driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"));
        WebElement element2=driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
        WebElement element3=driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[3]"));
        WebElement element4=driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[4]"));
        
        Actions action=new Actions(driver);
        action.keyDown(Keys.CONTROL).click(element1).click(element2).click(element3).click(element4).build().perform();

}
	
}
