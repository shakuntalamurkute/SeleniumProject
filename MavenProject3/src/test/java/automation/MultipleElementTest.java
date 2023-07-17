package automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import multipleElement.MultipleElementPage;
import multipleElement.Setup;

public class MultipleElementTest extends Setup {

	private MultipleElementPage multipleElementPage;

	@BeforeMethod
	public void setUpTest() {
		setUp();
		multipleElementPage = new MultipleElementPage(driver);
	}

	@Test
	public void selectMultipleElementsTest() {
		multipleElementPage.selectMultipleElements();
		boolean areElementsSelected = multipleElementPage.isElementsSelected();
		Assert.assertTrue(areElementsSelected, "All elements are not selected.");
		System.out.println(areElementsSelected);

	}

	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}
}
