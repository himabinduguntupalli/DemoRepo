package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//PageFactory
	@FindBy(xpath = "//input[@name ='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name ='password']")
	WebElement pword;
	@FindBy(xpath = "//input[@class ='btn btn-small']")
	WebElement loginBtn;
	@FindBy(xpath = "//button[contains(text ='Sign Up')]")
	WebElement signUpBtn;
	@FindBy(xpath = "//img[contains(@class ='img-responsive')]")
	WebElement crmLogo;
	
	//HomePage hPage;
	
public LoginPage()
{   
	PageFactory.initElements(driver, this);
}
public String validateLoginPageTitle()
{
	return driver.getTitle();
}
public boolean validateCRMImage()
{
	return crmLogo.isDisplayed();
}
public HomePage login(String un, String pwd)
{
	uname.sendKeys(un);
	pword.sendKeys(pwd);
	loginBtn.click();
	return new HomePage();
}

	}