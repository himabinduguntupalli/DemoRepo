package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtils;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			 prop = new Properties();
			FileInputStream fs = new FileInputStream("C:/Users/Naren/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialisation()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "//C:\\Users\\Naren\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "//C:\\Users\\Naren\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
        driver.get(prop.getProperty("url"));
			
	}
	

}
