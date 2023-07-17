package sort;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SortPage {
	
	    private WebDriver driver;
	    private By iframeLocator = By.className("demo-frame");
	    private By item1Locator = By.xpath("//li[@class='ui-state-default ui-sortable-handle' and text()='Item 1']");
	    private By item2Locator = By.xpath("//li[@class='ui-state-default ui-sortable-handle' and text()='Item 3']");

	    public SortPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void switchToSortableFrame() {
	        WebElement iframe = driver.findElement(iframeLocator);
	        driver.switchTo().frame(iframe);
	    }

	    public void performDragAndDrop() {
	        WebElement item1 = driver.findElement(item1Locator);
	        WebElement item2 = driver.findElement(item2Locator);

	        Actions actions = new Actions(driver);
	        actions.clickAndHold(item1).dragAndDropBy(item1, 0, 50).build().perform();  //0 pixels horizontally and 50 pixels vertically
	        actions.clickAndHold(item2).dragAndDropBy(item2, 1, 50).build().perform();
	    }
	    public String getItemTextByIndex(int index) {
	    	 WebElement item = driver.findElement(By.id("sortable"));
	    	    List<WebElement> sortableItems = item.findElements(By.tagName("li"));
	    	    WebElement sortableItem = sortableItems.get(index);
	    	    return sortableItem.getText();
	}
}