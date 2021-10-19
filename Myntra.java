package selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Myntra {
	
@Test
public void urlClock()
{
	String currentDir = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", currentDir +"\\Drivers\\chromedriver.exe"); 	
	WebDriver driver=new ChromeDriver();
	driver.get(" https://www.myntra.com/");
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit. SECONDS);
	
	WebElement element = driver.findElement(By.xpath("//a[@data-group='home-&-living']"));
	Actions action = new Actions(driver);

	action.moveToElement(element).perform();
	
	driver.findElement(By.linkText("Clocks")).click();
	
	String clockURL = driver.getCurrentUrl();
	Assert.assertEquals(clockURL, "https://www.myntra.com/clocks");
	
	driver.close();

}
}
