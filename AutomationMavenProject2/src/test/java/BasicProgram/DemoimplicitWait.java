package BasicProgram;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DemoimplicitWait {
		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
	// implicite wait
       		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			
			driver.findElement(By.name("q")).sendKeys("facebook");
			String txt = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li[1]/div/div[2]/div[1]/span")).getText();
			System.out.println("txt: " + txt);
			
			
			driver.quit();
		}		

}
