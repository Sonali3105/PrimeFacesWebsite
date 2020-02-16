package com.lean.qa.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Wait;

public class primefacesAjaxDropDownTest
{

	public String baseUrl = "https://www.primefaces.org/showcase/ui/ajax/dropdown.xhtml";
	public WebDriver driver; 
	
	@BeforeMethod
	public void setUp()
	{
		
		driver = new ChromeDriver();
		
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void testAjaxDropdown() throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);
		
		// locate "Select Country" dropdown by javaScriptExecutor
		WebElement country_select = driver.findElement(By.xpath("//div[@id='j_idt714:country']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']"));
		
		//wait until country_select dropdown to be clickable 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt714:country']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']")));
		
		       
		// click on "Select Country" dropdown by javaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", country_select);
		
		// locate the contryUL for getting all the option of country dropdown
		WebElement countryUL= driver.findElement(By.id("j_idt714:country_items"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt714:country_items")));
		
		//Checking if the Countries option is displayed on the Webpage and printing the status
		Assert.assertTrue(countryUL.isDisplayed()," Countries are displayed");
		
		//get all the options from the dropdown in countriesList variable 
		List<WebElement> countriesList=countryUL.findElements(By.tagName("li")); 
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='j_idt714:country_items']")));
		
		for (WebElement option : countriesList)
		{
			 if (option.getText().equals("USA"))
				{
				 option.click();
				 break;
				}
		}
		
		// locate "Select City" dropdown by javaScriptExecutor
		WebElement city_select = driver.findElement(By.xpath("//div[@id='j_idt714:city']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']"));
				
				
		//Wait for the Select city to appear in the AJAX DropDown
		By newAjaxcontrol = By.xpath("//div[@id='j_idt714:city']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']");
		@SuppressWarnings("deprecation")
		Wait<WebDriver> newwait = new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		newwait.until(ExpectedConditions
				.presenceOfElementLocated(newAjaxcontrol));

		
		//wait until city_select dropdown to be clickable 
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='j_idt714:city']//div[@class='ui-selectonemenu-trigger ui-state-default ui-corner-right']")));
		
		// click on "Select City" dropdown by javaScriptExecutor
		JavascriptExecutor jses = (JavascriptExecutor)driver;
		jses.executeScript("arguments[0].click();", city_select);
		
		// locate the cityUL for getting all the option from city dropdown
		WebElement cityUL= driver.findElement(By.id("j_idt714:city_items"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt714:city_items")));
		
		//Checking if the Cities option is displayed on the Webpage and printing the status
		Assert.assertTrue(cityUL.isDisplayed()," Cities are displayed");
				
		//get all the options from the city dropdown in cityList variable 
		List<WebElement> cityList=cityUL.findElements(By.tagName("li")); //get all the options from the dropdown
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='j_idt714:city_items']")));
		
		for (WebElement option : cityList)
		{
			 if (option.getText().equals("New York"))
				{
				 option.click();
				}
		}
		
		//locate the submit button and click on that
		WebElement submit = driver.findElement(By.id("j_idt714:j_idt724"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt714:j_idt724")));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", submit);
		
		//Verify the actual country selected with expected country
		WebElement country_lable= driver.findElement(By.id("j_idt714:country_label"));
		wait.until(ExpectedConditions.visibilityOf(country_lable));
		String actalCountryName= country_lable.getAttribute("value");
		Assert.assertEquals("USA",actalCountryName, "USA is not selected");
		
		//Verify the actual city selected with expected city
		WebElement city_lable= driver.findElement(By.id("j_idt714:city_label"));
		wait.until(ExpectedConditions.visibilityOf(city_lable));
		String actalCityName= city_lable.getAttribute("value");
		Assert.assertEquals("New York",actalCityName, "New York is not selected");
		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
	
	

}
