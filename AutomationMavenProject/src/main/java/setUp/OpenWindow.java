package setUp;


	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.chrome.ChromeOptions;



	import io.github.bonigarcia.wdm.WebDriverManager;



	public class OpenWindow {

		public static WebDriver driver;



		public static void setup() {

			ChromeOptions op = new ChromeOptions();

			op.addArguments("--remote-allow-origins=*");

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(op);

			driver.get("https://www.letcode.in");

			driver.manage().window().maximize();

		}

	}

