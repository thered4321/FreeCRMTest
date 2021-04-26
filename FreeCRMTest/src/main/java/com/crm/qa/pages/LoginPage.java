package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory---Object Repository 
	
	@FindBy(xpath = "//a[@href = 'https://ui.cogmento.com']")
	WebElement frontLoginBtn;
	
	@FindBy(xpath = "//body/div[1]/main[1]/section[1]/a[1]")
	WebElement signUpBtn;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions-----------------------------------------------------
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String uname,String pswd) throws InterruptedException
	{
		frontLoginBtn.click();
		Thread.sleep(1000);
		username.click();
		username.sendKeys(uname);
		Thread.sleep(1000);
		password.click();
		password.sendKeys(pswd);
		loginBtn.click();
		Thread.sleep(1000);
		return new HomePage();
	}
	
}
