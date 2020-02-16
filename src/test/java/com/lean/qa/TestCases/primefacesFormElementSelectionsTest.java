package com.lean.qa.TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class primefacesFormElementSelectionsTest 
{

	public String baseUrl = "https://www.primefaces.org/poseidon/forms.xhtml";
	public WebDriver driver; 
	
	@BeforeMethod
	public void setUp()
	{
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		//driver.navigate().refresh();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	
	
	@Test(priority = 1)
	public void testVerifyTitle() 
	{
		//get the title of page and print it
		System.out.println(driver.getTitle());
		// checking weather the expected title match with actual title or not?
		Assert.assertEquals("Forms", driver.getTitle(), "Title of web page is verified");
	}
	
	@Test(priority = 2)
	public void testInputText() 
	{
		// Store the location of name in name variable and send the value and verify with the actual name with expected name
		WebElement name= driver.findElement(By.id("j_idt70"));
		name.sendKeys("Sonali");
		String actalName= name.getAttribute("value");
		Assert.assertTrue(actalName.equals("Sonali"));
		
		// Store the location of email in email variable and send the value and verify with the actual email with expected email
		WebElement email= driver.findElement(By.xpath("//input[@id='j_idt71']"));
		email.sendKeys("sonalipatel@gmail.com");
		String actalEmail= email.getAttribute("value");
		Assert.assertTrue(actalEmail.equals("sonalipatel@gmail.com"));
		
		// Store the location of phone in phone variable and send the value and verify with the actual phone with expected phone
		WebElement phone= driver.findElement(By.xpath("//input[@id='j_idt72']"));
		phone.sendKeys("5193183737");
		String actalPhone= phone.getAttribute("value");
		Assert.assertTrue(actalPhone.equals("5193183737"));
	}
	
	@Test(priority = 3)
	public void testInputNameInvalid() 
	{
		// Store the location of name in name variable and send the value and verify with the actual name with expected name
		WebElement name= driver.findElement(By.id("j_idt70"));
		name.sendKeys("Sonali$%^&1542");
		String actalName= name.getAttribute("value");
		Assert.assertEquals("Sona",actalName, "Please enter correct name in Name field");
	}
	
	@Test(priority = 4)
	public void testInputEmailInvalid() 
	{
		// Store the location of email in email variable and send the value and verify with the actual email with expected email
		WebElement email= driver.findElement(By.xpath("//input[@id='j_idt71']"));
		email.sendKeys("sonalipatel.com");
		String actalEmail= email.getAttribute("value");
		Assert.assertEquals("sonapatel@gmail.com",actalEmail, "Please enter correct email in Email field");
	}
	
	@Test(priority = 5)
	public void testInputPhoneInvalid() 
	{
		// Store the location of phone in phone variable and send the value and verify with the actual phone with expected phone
		WebElement phone= driver.findElement(By.xpath("//input[@id='j_idt72']"));
		phone.sendKeys("519ghbj7%^&");
		String actalPhone= phone.getAttribute("value");
		Assert.assertEquals("5193183737",actalPhone, "Please enter correct phone in Phone field");
	}
	
	@Test(priority = 6)
	public void testCheckboxes() 
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		
		//Define the check box in a varaible
		WebElement checkbox_PS4 ;
		
		//Define explicit wait for checkbox_PS4 variable and store its location in checkbox_PS4 variable also
		checkbox_PS4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='j_idt104']//div[2]//div[1]//div[2]")));
		
		 //Checking if the PS4 checkbox is displayed on the Webpage and printing its status
		Assert.assertTrue(checkbox_PS4.isDisplayed(),"PS4 checkbox is displayed");
		
        //Checking if the PS4 checkbox is enabled on the webpage and printing its status
		Assert.assertTrue(checkbox_PS4.isEnabled(),"PS4 checkbox is enabled");
       
        //Selecting the PS4 checkbox
		checkbox_PS4.click();
	}
	
	@Test(priority = 7)
	public void testRadioButtons() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		
		//Define the radio button in a varaible
		WebElement radio_wii_U ;
		
		//Define explicit wait for radio_wii_U variable and store its location in radio_wii_U variable also
		radio_wii_U = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='j_idt109']//div[3]//div[1]//div[2]//span[1]")));
		
		//Checking if the Wii U Radio button is displayed on the Webpage and printing the status
		Assert.assertTrue(radio_wii_U.isDisplayed(),"Wii_U radio button is displayed");
        
        //Checking if the Wii U Radio button is enabled on the webpage and printing the status
		Assert.assertTrue(radio_wii_U.isEnabled(),"Wii_U radio button is enabled");
       
        //clicking on Wii_U radio button
		radio_wii_U.click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 8)
	public void testSelectOneMenu() 
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
		
		// locate the SelectOneMenu for scroll Into view 
		WebElement selectOneLabel = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[4]/h1"));
		JavascriptExecutor je= (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", selectOneLabel);
		
		
		//Define explicit wait for SelectOne variable and locate the select drop down field in SelectOne variable
		WebElement SelectOne;
		SelectOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='console_label']")));
		
		//clicking on SelectOne dropdown
		SelectOne.click();
		
		// locate the options from list like "Xbox One"
		WebElement dropDown = driver.findElement( By.xpath(".//*[@id='console_1']"));
		
		//Checking if the Xbox One option is displayed on the Webpage and printing the status
		Assert.assertTrue(dropDown.isDisplayed()," Xbox One option is displayed");
       
        //Checking if the  Xbox One option is enabled on the webpage and printing the status
		Assert.assertTrue(dropDown.isEnabled()," Xbox One option is enabled");
     
        //Clicking on Xbox One option from drop down
		dropDown.click();
	}
	
	@Test(priority = 9)
	public void testEnterDate() 
	{
		// scrolling until date popup does not appear 
		JavascriptExecutor je= (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("j_idt97")));
		
		//locate the popup date input field and 
		WebElement date = driver.findElement(By.id("popup_input"));
		
		//Define the value of date in dateval 
		String dateval = "2/15/19"; // Enter date in mm/dd/yy
		
		//Enter the date value by javascriptExecutor
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('value','"+dateval+"');", date);
		
		
		//Checking whether the actual date should match with expected date or not? 	
		String actualDate =date.getAttribute("value");
		Assert.assertTrue(actualDate.equals("2/15/19"));
	}
	
	@Test(priority = 10)
	public void testSelectDate() throws InterruptedException 
	{
				WebDriverWait wait=new WebDriverWait(driver, 30);
				
				// scrolling until date popup label does not appear 
				JavascriptExecutor je= (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("j_idt97")));
				//je.executeScript("scroll(0, 1900)");
				
				Thread.sleep(2000);
				//click on the Popup date input field to select the date
				WebElement date_inputField = driver.findElement(By.id("popup_input"));
				wait.until(ExpectedConditions.visibilityOf(date_inputField));
			
				//Click on date_inputField by javaScriptExecutor
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", date_inputField);
		
				Thread.sleep(2000);
				
				// define current month year
				WebElement currentMonthYear = driver.findElement(By.cssSelector("body.main-body:nth-child(2) div.ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all.ui-shadow.ui-input-overlay:nth-child(9) div.ui-datepicker-header.ui-widget-header.ui-helper-clearfix.ui-corner-all > div.ui-datepicker-title"));
				wait.until(ExpectedConditions.visibilityOf(currentMonthYear));
				
				//Click on currentMonthYear by javaScriptExecutor
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", currentMonthYear);
		
				//define expected month year
				String expMonthYear = "March 2020";
				
				//get the current month and year 
				String Current_MonthYear_Text = currentMonthYear.getText(); 
				Thread.sleep(3000);
				
				// Compare the expectations month year with current month year
				if(expMonthYear.equals(Current_MonthYear_Text))
				{
					System.out.println("Month is already selected");
				}
				else
				{
					//Iterate the loop for 12 times until desired month year is not selected 
					for(int i =1; i<=12; i++)
					{
						Thread.sleep(3000);
						//Locate the next button on Calander
						WebElement next = driver.findElement(By.xpath(".//*[@class='ui-datepicker-next ui-corner-all']"));
						next.click();
						
						if(expMonthYear.equals(Current_MonthYear_Text))
						{
							Thread.sleep(3000);
							System.out.println("Month selected");
							break;
						}	
					}
				}
				
				//define expected date
				String expDate ="3/15/20";
				
				Thread.sleep(3000);
				// locate the datepicker table
				WebElement dateTable = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody"));

				Thread.sleep(3000);
				//list all the dates in dates variable
				 java.util.List<WebElement> dates = dateTable.findElements(By.tagName("td"));
				  
				  for(WebElement date : dates)
				  {
					  Thread.sleep(3000);
					  String calDate = date.getText();
					  if(calDate.equals(expDate))
					  {
					  Thread.sleep(3000);
					  date.click();
					  break;
					  }
				  }
				
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
	
}
