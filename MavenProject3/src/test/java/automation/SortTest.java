package automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sort.Setup;
import sort.SortPage;

public class SortTest extends Setup {
    private SortPage sortPage;

    @BeforeMethod
    public void setUpTest() {
        setUp();
        sortPage = new SortPage(driver);
    }

    @Test
    public void performSortTest() {
       
        sortPage.switchToSortableFrame();
        sortPage.performDragAndDrop();
        String expectedItem1 = "Item 2";
        String expectedItem2 = "Item 1";
        
        // Get the actual items after sorting
        String actualItem1 = sortPage.getItemTextByIndex(0);
        String actualItem2 = sortPage.getItemTextByIndex(1);

        // Perform assertions
        Assert.assertEquals(actualItem1, expectedItem1, "Item 1 is not sorted correctly.");
        Assert.assertEquals(actualItem2, expectedItem2, "Item 2 is not sorted correctly.");
       
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}

