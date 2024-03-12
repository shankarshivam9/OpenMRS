package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC03_LogoutScreen {

	@FindBy(partialLinkText = "Logout")
	private WebElement lnkLogout = null;

	public TC03_LogoutScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logout() {
		lnkLogout.click();
	}

}
