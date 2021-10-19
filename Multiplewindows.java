package selenium2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Multiplewindows 
{
	@Test
	public void handleMultipleWindow()
	{

	    String currentDir = System.getProperty("user.dir");
	 	System.setProperty("webdriver.chrome.driver", currentDir + "\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
	 
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
    
		driver.manage().timeouts().implicitlyWait(25, TimeUnit. SECONDS);

		driver.findElement(By.id("windowButton")).click();

		String mainWindowHandle = driver.getWindowHandle();
    
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
    
		while (iterator.hasNext()) 
		{
			String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
            {
            	driver.switchTo().window(ChildWindow);
           
	            System.out.println("Tittle of the New window is: "+ driver.getTitle());
	            System.out.println("Text inside New window is: "+driver.findElement(By.id("sampleHeading")).getText());   
            }
		}
		driver.switchTo().window(mainWindowHandle);
    
    driver.quit();
	}
}
