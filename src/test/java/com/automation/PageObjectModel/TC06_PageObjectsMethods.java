package com.automation.PageObjectModel;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.screens.TC01_LoginScreen;
import com.automation.screens.TC03_LogoutScreen;
import com.automation.screens.TC02_RegisterScreen;

public class TC06_PageObjectsMethods extends BaseTest {

	@Test
	public static void createRecord() throws Exception {

		// Login using Page Object Model
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		TC01_LoginScreen loginScreen = new TC01_LoginScreen(driver);
		loginScreen.login();

		// Register using Page Object Model
		TC02_RegisterScreen registerScreen = new TC02_RegisterScreen(driver);
		registerScreen.register();

		// Logout using Page Object Model
		TC03_LogoutScreen logoutScreen = new TC03_LogoutScreen(driver);
		logoutScreen.logout();

	}

}
