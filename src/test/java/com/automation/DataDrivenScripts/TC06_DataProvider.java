package com.automation.DataDrivenScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

import java.time.Duration;

public class TC06_DataProvider extends BaseTest {

	// DataProviders in the same class

	@Test(dataProvider = "getTestData")
	public void createRecord(String username, String password, String firstName, String lastName, String gender,
			String date, String month, String year, String address, String mobileNumber) throws InterruptedException {

		// Login
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Registration Desk")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.partialLinkText("Register a patient")).click();

		driver.findElement(By.name("givenName")).sendKeys(firstName);
		driver.findElement(By.name("familyName")).sendKeys(lastName);
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("gender-field")).sendKeys(gender);
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("birthdateDay-field")).sendKeys(date);
		driver.findElement(By.id("birthdateMonth-field")).sendKeys(month);
		driver.findElement(By.id("birthdateYear-field")).sendKeys(year);

		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("address1")).sendKeys(address);
		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys(mobileNumber);

		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("submit")).click();

		Thread.sleep(12000);

		String str = driver.findElement(By.xpath("//em[text()='Patient ID']/../span")).getText();
		System.out.println("ID is :  " + str);

		Thread.sleep(5000);
		// logout
		driver.findElement(By.partialLinkText("Logout")).click();

		// close browser
		Thread.sleep(5000);

	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() {

		Object[][] data = {
				{ "Admin", "Admin123", "SCOTT", "TIGER", "MALE", "11", "MAY", "1991", "Hyderabad", "900023423422" },
				{ "Admin", "Admin123", "SCOTT", "TIGER", "MALE", "12", "MAY", "1992", "Chennai", "9000555555555" },
				{ "Admin", "Admin123", "SCOTT", "TIGER", "MALE", "13", "MAY", "1993", "DELHI", "9000666666666" }
		};
		return data;
	}
}