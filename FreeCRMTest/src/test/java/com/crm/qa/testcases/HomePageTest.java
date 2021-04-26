package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ContactsPage contactsPage;
	public static DealsPage dealsPage;
	public static TasksPage tasksPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage 		= new LoginPage();
		contactsPage 	= new ContactsPage();
		dealsPage	 	= new DealsPage();
		tasksPage 		= new TasksPage();
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home Page Title not match");		
	}
	
	@Test(priority = 2)
	public void verifyUserNameLabelTest()
	{
		Boolean usernameLabel = homePage.verifyUserName();
		Assert.assertTrue(usernameLabel);
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest()
	{
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 4)
	public void verifyclickOnDealsLinkTest()
	{
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority = 5)
	public void verifyclickOnTasksLinkTest()
	{
		tasksPage = homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	
}
