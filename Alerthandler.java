package selenium2;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Alerthandler

{
	@Test
   public void testpart1()
   {	
		String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDir +"\\Drivers\\chromedriver.exe"); 	
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit. SECONDS);

		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("alertButton")));	
		driver.findElement(By.id("alertButton")).sendKeys(Keys.ENTER);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("**********************");
		System.out.println(alertText);
		alert.accept();
		
	    driver.close();  
   }

	
	
	@Test
	   public void testpart2()
	   {
		
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\Swati Panwar\\eclipse-workspace\\Selenium_Project_Test\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://demoqa.com/alerts");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit. SECONDS);
			
			Actions actions=new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("confirmButton")));	
			driver.findElement(By.id("confirmButton")).sendKeys(Keys.ENTER);
			
			Alert alert_Dismiss = driver.switchTo().alert();
			alert_Dismiss.dismiss();
			
			driver.close();  
	   }
	
	
	@Test
	   public void testpart3()
	   {		
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\Swati Panwar\\eclipse-workspace\\Selenium_Project_Test\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://demoqa.com/alerts");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit. SECONDS);
			
			Actions actions=new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("promtButton")));		
			driver.findElement(By.id("promtButton")).sendKeys(Keys.ENTER);
			
			Alert alert_Prompt = driver.switchTo().alert();
			alert_Prompt.sendKeys("Hello world");
			alert_Prompt.accept();
	
			driver.close();  
	   }
	
	@Test
	   public void testpart4()
	   {
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\Swati Panwar\\eclipse-workspace\\Selenium_Project_Test\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://demoqa.com/alerts");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit. SECONDS);

			Actions actions=new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("confirmButton")));	
			driver.findElement(By.id("confirmButton")).sendKeys(Keys.ENTER);
			
			Alert alert_Prompt = driver.switchTo().alert();
			alert_Prompt.accept();

		    driver.close();  
	   }
	}
