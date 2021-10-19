package selenium2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Dropdown 
{
	@Test
	public static void test1()
	{
		String currentDir = System.getProperty("user.dir");
	 	System.setProperty("webdriver.chrome.driver", currentDir + "\\Drivers\\chromedriver.exe"); 	
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit. SECONDS);
		driver.get("https://demoqa.com/select-menu");
		
		
		//**** Drop-down is multiselect		**********//
		Select oldStyleSelectMenu = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
		boolean isMultipleDropDown = oldStyleSelectMenu.isMultiple();
		System.out.println("This Drop-Down is MultiSelect: "+isMultipleDropDown);
		
		
		//********** Dropdown options***************//
		
		Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
		
		List<WebElement> options = select.getOptions();
		System.out.println("DropDowns Options:");
		for(WebElement i :options)
		{
			System.out.println(i.getText());
		}
		
		driver.close();
	}
	


@Test
public static void test2()
	{
		String currentDir = System.getProperty("user.dir");
	 	System.setProperty("webdriver.chrome.driver", currentDir + "\\Drivers\\chromedriver.exe"); 	
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit. SECONDS);
		driver.get("https://demoqa.com/select-menu");

		Select select = new Select(driver.findElement(By.id("cars")));
		
		select.selectByVisibleText("Volvo");
		select.selectByVisibleText("Saab");
		select.selectByVisibleText("Audi");
		
		//**********All selected option***********
		
		List<WebElement> selected_options = select.getAllSelectedOptions();
		
		//*****Last selected option*************
		System.out.println("The last selected Option is: "+selected_options.get(selected_options.size()-1).getText());
		
		//*********fetching the all selected option**************
		System.out.println("Selected Options List: ");
		for(WebElement i :selected_options)
		{
			System.out.println(i.getText());
		}
		
		//*********** De-select the  selected option*************
		select.deselectAll();
		
		driver.close();
	
	}
}


