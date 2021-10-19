package selenium2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iframe {
		
	@Test
	public void testMethod() 
	{
		String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDir +"\\Drivers\\chromedriver.exe"); 	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit. SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit. SECONDS);
		
		List<WebElement> numbersOfIFrame = driver.findElements(By.xpath("//iframe[@src='SingleFrame.html']"));
		System.out.println("The Count of numbers of Iframes are: "+ (numbersOfIFrame.size()+1));
		
		driver.switchTo().frame(driver.findElement(By.id("singleframe")));
		driver.findElement(By.tagName("input")).sendKeys("Single-Iframe");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit. SECONDS);
		driver.switchTo().defaultContent();
		
	
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		System.out.println(driver.switchTo().frame(1));

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Iframe inside Iframe");
		//driver.manage().timeouts().implicitlyWait(80, TimeUnit. SECONDS);
		driver.close();
	}
}
