package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC04_LoginScreen_Parameterization {

	@FindBy(id = "username")
	private WebElement txtUserName = null;

	@FindBy(id = "password")
	private WebElement txtPassword = null;

	@FindBy(id = "Registration Desk")
	private WebElement lnkRegistration = null;

	@FindBy(id = "loginButton")
	private WebElement btnLogin = null;

	// write a constructor
	public TC04_LoginScreen_Parameterization(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void login(String userName, String password) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		lnkRegistration.click();
		btnLogin.click();
	}

}
