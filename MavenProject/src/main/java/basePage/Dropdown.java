package basePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/");
		driver.manage().window().maximize();
  
	    driver.get("https://letcode.in/dropdowns");  
	     
	    WebElement fruitsEle=driver.findElement(By.id("fruits"));
	    Select fruits=new Select(fruitsEle);
	    fruits.selectByVisibleText("Banana");
	    fruits.selectByVisibleText("Orange");
	        
	    
	    
	    
	    WebElement heroEle=driver.findElement(By.id("superheros"));
	    Select heros=new Select(heroEle);
	    
	    boolean multiple =heros.isMultiple();
	    System.out.println(multiple);
	    heros.selectByIndex(2);
	    heros.selectByValue("ca");
	    heros.deselectByVisibleText("Iron Man");
	        
	    
	    List<WebElement>allSelectOPtions=heros.getAllSelectedOptions();
	    for(WebElement hero:allSelectOPtions)
	    	System.out.println(hero.getText());
	    {
	    	
	    }
	   
	
	
}
}