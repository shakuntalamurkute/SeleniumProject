package BasicProgram;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutocompleteDemo {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    @Test
    public void testAutocomplete() {
        driver.findElement(By.name("q")).sendKeys("selenium");

        // Wait for the autocomplete suggestions to appear
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li[@class='sbct']//div[@role='presentation']/span"));
        System.out.println("Size of Autocomplete suggestions: " + suggestions.size());

        // Print the suggestions
        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
        }
    }
}
