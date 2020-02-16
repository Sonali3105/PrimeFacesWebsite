package com.lean.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lean.qa.base.TestBase;
import com.lean.qa.pages.primefacesLogin;

public class primefacesLoginTest extends TestBase
{
	primefacesLogin login;
	// HomePage homePage;
	
	public primefacesLoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		login = new primefacesLogin();	
	}
	
	@Test(priority=1)
	public void verifyLoginLogoDisplay()
	{
		Assert.assertTrue( login.displayLoginLogo(),"Login label is missing on the page");
		login.clickOnLoginLogo();
	}
	
//	@Test(priority=2)
//	public void verifyLoginLogoClick()
//	{
//		login.clickOnLoginLogo();
//	}
	
	@Test(priority=3)
	public void verifyUsernameDisplay()
	{
		login.clickOnLoginLogo();
		Assert.assertTrue( login.displayUsernameLabel(),"Username label is missing on the page");
	}
	
	@Test(priority=4)
	public void verifyPasswordDisplay()
	{
		login.clickOnLoginLogo();
		Assert.assertTrue( login.displayPasswordLabel(),"Password label is missing on the page");
	}
	
	@Test(priority=7)
	public void loginTest3()
	{
		login.clickOnLoginLogo();
		login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=5)
	public void loginTest()
	{
		login.clickOnLoginLogo();
		login.login("sona&*","sona523");
		
	}
	
	@Test(priority=6)
	public void loginTest1()
	{
		login.clickOnLoginLogo();
		login.login("68678889787898789","&*&&***&**(********");	
	}
	
	@Test(priority=8)
	public void verifyloginTest() throws InterruptedException
	{
		Thread.sleep(2000);
		login.clickOnLoginLogo();
		String name =login.usernameValue();
		Assert.assertEquals("admin",name);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
