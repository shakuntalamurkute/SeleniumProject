package automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drag.DragPage;
import drag.Setup;

public class DragPageTest extends Setup {
	private DragPage dragPage;

	@BeforeMethod
	public void setUpTest() {
		setUp();

		dragPage = new DragPage(driver);
	}

	@Test
	public void performDragAndDropTest() {
		dragPage.performDragAndDrop();
		int[] draggableElementPosition = dragPage.getDraggableElementPosition();
        int draggableElementX = draggableElementPosition[0];
        int draggableElementY = draggableElementPosition[1];
        
        Assert.assertEquals(draggableElementX, 108, "The draggable element was not dragged horizontally to the expected position.");
        System.out.println(draggableElementX);
        Assert.assertEquals(draggableElementY, 108, "The draggable element was not dragged vertically to the expected position.");
        System.out.println(draggableElementY);
	}

	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
}
