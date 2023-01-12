package com.ESS.Payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//button[.=' Log in ']")
	WebElement LoginButton;
	
	public void enter_credential(String uname, String pwd)
	{
		Username.sendKeys(uname);
		Password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		LoginButton.click();
	}

}
