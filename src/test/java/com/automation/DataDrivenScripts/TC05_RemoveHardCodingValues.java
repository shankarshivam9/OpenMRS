package com.automation.DataDrivenScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

import java.time.Duration;

public class TC05_RemoveHardCodingValues extends BaseTest {
	
	// Remove HardCoding of Values by setting into a variable

	@Test
	public void createRecord() throws InterruptedException {

		String username = "Admin";
		String password = "Admin123";
		String firstName = "SCOTT";
		String lastName = "TIGER";
		String gender = "Male";
		String date = "11";
		String month = "May";
		String year = "1991";
		String address = "Hyderabad";
		String mobileNumber = "900055271111";

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

}
