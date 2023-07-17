package automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dragDrop.DragDropPage;
import dragDrop.Setup;

public class DragDropTest {
	public class DragAndDropTest extends Setup {
		private DragDropPage dragDropPage;

		@BeforeMethod
		public void setUpTest() {
			setUp();

			dragDropPage = new DragDropPage(driver);
		}

		@Test
		public void performDragAndDropTest() {
			dragDropPage.performDragAndDrop();
			String droppableText = dragDropPage.getDroppableText();
			Assert.assertEquals(droppableText, "Dropped!", "Drag and drop operation failed.");
			System.out.println(droppableText);

		}

		@AfterMethod
		public void tearDownTest() {
			tearDown();
		}
	}

}
