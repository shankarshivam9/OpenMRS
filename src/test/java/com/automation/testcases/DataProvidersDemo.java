package com.automation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersDemo {
	WebDriver driver = null;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test(dataProvider = "getTestData")
	public void Login(String username, String password) throws InterruptedException {

		// Login
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() {

		Object[][] data = { { "Admin", "Admin123" }

		};
		return data;
	}
}
