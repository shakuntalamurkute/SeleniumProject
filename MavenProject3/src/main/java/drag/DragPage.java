package drag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragPage {
	private WebDriver driver;

    public DragPage(WebDriver driver) {
        this.driver = driver;
    }

    public void performDragAndDrop() {
        driver.switchTo().frame(0);
        WebElement draggable = driver.findElement(By.id("draggable"));
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggable, 100, 100).perform();
    }
    public int[] getDraggableElementPosition() {
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        int x = draggableElement.getLocation().getX();
        int y = draggableElement.getLocation().getY();
        return new int[]{x, y};
}
}

