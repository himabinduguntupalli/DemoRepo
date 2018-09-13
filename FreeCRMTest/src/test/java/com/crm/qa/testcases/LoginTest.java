package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		TestBase.initialisation();
		loginPage = new LoginPage();// LoginPage constructor
		//homePage = new HomePage();// HomePage constructor
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String ActualTitle = loginPage.validateLoginPageTitle();
		String ExpectedTitle = prop.getProperty("LoginPageTitle");
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		Assert.assertTrue(loginPage.validateCRMImage());
	}
	
	@Test(priority=3)
	public void LoginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
