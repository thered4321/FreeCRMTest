package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	//PageFactory(O.R.)
	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
//	@FindBy(xpath = "//input[@class = 'hidden']")
//	WebElement contactsCheckbox;                         //Because it will check only particular checkbox that's why commented
	
	//Initializing the O.R.
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public Boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
		
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div//input[@class='hidden']")).click();;
		
	}
	
}
