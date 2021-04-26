package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage 		= new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}
	@Test(priority = 2)
	public void loginPageLoginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void teraDown()
	{
		driver.quit();
	}
	
}
