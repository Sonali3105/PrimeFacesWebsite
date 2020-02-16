package com.lean.qa.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class primefacesDataTableTest {

	public String baseUrl = "https://www.primefaces.org/showcase/ui/data/datatable/selection.xhtml";
	public WebDriver driver; 
	
	
	@BeforeMethod
	public void setUp()
	{
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		//driver.navigate().refresh();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test(priority = 1)
	public void testSelectRadioButtonInGrid() throws InterruptedException 
	{
		Thread.sleep(2000);
		// scrolling until radio button label does not appear 
		JavascriptExecutor je= (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'RadioButton')]")));
		
		
		//Locate the ID element and store in two different variable
		String beforeXpath = "//div[@id='form:radioDT']//tr[";
		String afterXpath = "]//td[2]";
		
		Thread.sleep(2000);
		//iterate the loop until expected Id does not click from the list and if does not click then it will give error 
		for(int i=1; i<=10; i++)
		{
			//get the text of ID from ID's location and print it  
			String val= driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			System.out.println(val);
			//If ID= "c43ba8e8" is present then it will click on radio vutton otherwise it will give an error message
			if(val.contains("c43ba8e8"))
			{	 
			driver.findElement(By.xpath("//div[@id='form:radioDT']//tr["+i+"]//td[1]//div[1]//div[2]//span[1]")).click();		
			}
			else
				System.out.println("ID is not presented in list for now so can not click on c43ba8e8 ID ");
		}
	}

	@Test(priority = 2)
	public void testSelectCheckBoxInGrid() throws InterruptedException 
	{
		Thread.sleep(2000);
		// scrolling until radio button label does not appear 
		JavascriptExecutor je= (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'Checkbox')]")));
		
		//div[@id='form:checkboxDT']//tr[4]//td[1]
		
		//div[@id='form:checkboxDT']//tr[4]//td[1]//div[1]//div[2]//span[1]
		
		//Locate the ID element and store in two different variable
		String beforeXpath = "//div[@id='form:checkboxDT']//tr[";
		String afterXpath = "]//td[2]";
		
		Thread.sleep(2000);
		//iterate the loop until expected Id does not check on the list and if does not check then it will give error 
		for(int i=1; i<=10; i++)
		{
			//get the text of ID from ID's location and print it  
			String val= driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			System.out.println(val);
			//If ID= "7befc577" and "ae738e10" is present then it will click on check boxes otherwise it will give an error message
			if(val.contains("7befc577") && val.contains("ae738e10"))
			{
			driver.findElement(By.xpath("//div[@id='form:checkboxDT']//tr["+i+"]//td[1]//div[1]//div[2]//span[1]")).click();		
			}
			else
				System.out.println("ID is not presented in list for now so can not check on Id 7befc577 & Id ae738e10 ");
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
	

}

