package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ContactsPage contactsPage;

	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage		= new LoginPage();
		homePage 		= new HomePage();
		contactsPage 	= new ContactsPage();
		homePage 		= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest()
	{
		Boolean label = contactsPage.verifyContactsLabel();
		Assert.assertTrue(label,"Contacts label is missing on page");
	}
	
	@Test(priority = 2)
	public void SelectContactsByNameTest()
	{
		contactsPage.selectContactsByName("sdfg xcvbn");
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
}
