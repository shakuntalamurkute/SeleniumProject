package automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.FramePage;

public class FrameTest {
	private ChromeDriver driver;
	private FramePage framePage;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/frame");
		framePage = new FramePage(driver);

	}

	@Test
	public void frameTest() {
		framePage.switchToFirstFrame();
		framePage.enterFirstName("Koushik");
		framePage.enterLastName("Chatterje");
		framePage.switchToSecondFrame();
		framePage.enterEmail("mail@mail.com");
		framePage.switchToDefaultContent();
		framePage.clickWatchTutorialButton();

		// Assert that the tutorial page is opened
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://letcode.in/video/frames"), "Tutorial page is not opened");

		// Assert the page title
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "LetCode - Every problem has a solution", "Page title is incorrect");
		System.out.println("page title is:"  +pageTitle);

	}

	//@AfterClass
	//public void tearDown() {
		//driver.quit();
	//}
}