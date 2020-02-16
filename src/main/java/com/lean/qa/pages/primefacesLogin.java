package com.lean.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.lean.qa.base.TestBase;


public class primefacesLogin extends TestBase {
	
	//page Factory- OR
	
	@FindBy(id="j_idt714:j_idt716")
	WebElement LoginLogo;
	
	@FindBy(id="j_idt714:username")
	WebElement username_textBox;
	
	@FindBy(id="j_idt714:password")
	WebElement password_textbox;
	
	@FindBy(xpath="//span[@class='ui-button-text ui-c']")
	WebElement login_btn;

	
	@FindBy(xpath="//label[contains(text(),'Username:')]")
	WebElement username_label;
	
	@FindBy(xpath="//label[contains(text(),'Username:')]")
	WebElement password_label;
	
	
	public primefacesLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	// perform actions 
	public boolean displayLoginLogo()
	{
		return LoginLogo.isDisplayed();
	}
	public void clickOnLoginLogo()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", LoginLogo);
	}
	public boolean displayUsernameLabel()
	{
		return username_label.isDisplayed();
	}
	public boolean displayPasswordLabel()
	{
		return password_label.isDisplayed();
	}
	
	public void login(String username, String password)
	{
		username_textBox.sendKeys(username);

		password_textbox.sendKeys(password);
		
		login_btn.click();
	}
	
	public String usernameValue()
	{
		return username_textBox.getAttribute("value");
		
	}
	

}
