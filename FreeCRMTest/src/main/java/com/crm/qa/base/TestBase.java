package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtils;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	
	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream f_is = new FileInputStream("D:\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(f_is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\FreeCRMTest\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\eclipse-workspace\\FreeCRMTest\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.ImplicitWait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
