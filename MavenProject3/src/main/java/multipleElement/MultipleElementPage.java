package multipleElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MultipleElementPage {
	 private WebDriver driver;

	    public MultipleElementPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectMultipleElements() {
	        WebElement iframe = driver.findElement(By.tagName("iframe"));
	        driver.switchTo().frame(iframe);
      

	  
	        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[1]"));
	        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
	        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[3]"));
	        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[4]"));

	        Actions action = new Actions(driver);
	        action.keyDown(Keys.CONTROL).click(element1).click(element2).click(element3).click(element4).build().perform();
	    }
	       
	    public boolean isElementsSelected() {
	        WebElement selectableList = driver.findElement(By.id("selectable"));
	        int selectedCount = selectableList.findElements(By.className("ui-selected")).size();
	        return selectedCount == 4; 
	    }
}
	

