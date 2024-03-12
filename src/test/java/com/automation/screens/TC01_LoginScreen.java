package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC01_LoginScreen {

	@FindBy(id = "username")
	private WebElement txtUserName = null;

	@FindBy(id = "password")
	private WebElement txtPassword = null;

	@FindBy(id = "Registration Desk")
	private WebElement lnkRegistration = null;

	@FindBy(id = "loginButton")
	private WebElement btnLogin = null;

	// write a constructor
	public TC01_LoginScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void login() {
		txtUserName.sendKeys("Admin");
		txtPassword.sendKeys("Admin123");
		lnkRegistration.click();
		btnLogin.click();
	}

}
