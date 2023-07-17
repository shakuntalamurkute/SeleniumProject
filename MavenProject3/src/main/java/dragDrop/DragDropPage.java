package dragDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
	private WebDriver driver;

	public DragDropPage(WebDriver driver) {
		this.driver = driver;
	}

	public void performDragAndDrop() {
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggable, droppable).perform();
	}

	public String getDroppableText() {
		WebElement droppable = driver.findElement(By.id("droppable"));
		return droppable.getText();
	}

}
