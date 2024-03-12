package com.automation.hybrid;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.screens.TC01_LoginScreen;
import com.automation.screens.TC03_LogoutScreen;
import com.automation.screens.TC04_LoginScreen_Parameterization;
import com.automation.screens.TC05_RegisterScreen_Parameterization;
import com.automation.screens.TC02_RegisterScreen;

public class TC01_Hybrid extends BaseTest {

	@Test
	public static void createRecord() throws Exception {

		// Login using Page Object Model
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		TC04_LoginScreen_Parameterization logiScreen_Parameterization = new TC04_LoginScreen_Parameterization(driver);
		logiScreen_Parameterization.login("Admin", "Admin123");

		// Register using Page Object Model
	//	TC02_RegisterScreen registerScreen = new TC02_RegisterScreen(driver);
		
		TC05_RegisterScreen_Parameterization registerScreen_Parameterization = new TC05_RegisterScreen_Parameterization(driver);
		registerScreen_Parameterization.register("SCOTT", "TIGER","MALE","11","MAY","1982","Hyderabad","900055471211");

		// Logout using Page Object Model
		TC03_LogoutScreen logoutScreen = new TC03_LogoutScreen(driver);
		logoutScreen.logout();

	}

}
