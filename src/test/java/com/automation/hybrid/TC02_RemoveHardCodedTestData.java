package com.automation.hybrid;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.helper.ExcelHelperParameterized;
import com.automation.screens.TC01_LoginScreen;
import com.automation.screens.TC03_LogoutScreen;
import com.automation.screens.TC04_LoginScreen_Parameterization;
import com.automation.screens.TC05_RegisterScreen_Parameterization;
import com.automation.screens.TC02_RegisterScreen;

public class TC02_RemoveHardCodedTestData extends BaseTest {

	@Test(dataProvider = "getTestData")
	public static void createRecord(String userName, String password, String firstName, String lastName, String gender,
			String date, String month, String year, String address, String mobileNumber) throws Exception {

		TC04_LoginScreen_Parameterization logiScreen_Parameterization = new TC04_LoginScreen_Parameterization(driver);
		logiScreen_Parameterization.login(userName, password);

		TC05_RegisterScreen_Parameterization registerScreen_Parameterization = new TC05_RegisterScreen_Parameterization(
				driver);
		registerScreen_Parameterization.register(firstName, lastName, gender, date, month, year, address, mobileNumber);

		// Logout using Page Object Model
		TC03_LogoutScreen logoutScreen = new TC03_LogoutScreen(driver);
		logoutScreen.logout();

	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() throws Exception {
		Object[][] data = ExcelHelperParameterized.getTestData(
				"D:\\2023\\Automation\\Selenium\\Workplace_Apr\\OpenMRS\\src\\test\\resources\\OpenMRSLogin.xls",
				"Sheet1");
		return data;
	}
}
