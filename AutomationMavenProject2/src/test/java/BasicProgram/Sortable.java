package BasicProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();


    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://jqueryui.com/sortable/");

    WebElement iframe = driver.findElement(By.className("demo-frame"));
    driver.switchTo().frame(iframe);

    WebElement item1 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle' and text()='Item 1']"));
    WebElement item2 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle' and text()='Item 3']"));

    Actions actions = new Actions(driver);
    actions.clickAndHold(item1).dragAndDropBy(item1, 0, 50).build().perform();
    actions.clickAndHold(item2).dragAndDropBy(item2, 1, 50).build().perform();
	}
}

