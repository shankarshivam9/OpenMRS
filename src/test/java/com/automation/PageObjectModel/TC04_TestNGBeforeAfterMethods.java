package com.automation.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC04_TestNGBeforeAfterMethods {

	static WebDriver driver = null;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	@Test
	public static void createRecord() throws Exception {

		// Login to openmrs website and login , register, logout and close browser

		// Login
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Registration Desk")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.partialLinkText("Register a patient")).click();

		driver.findElement(By.name("givenName")).sendKeys("SCOTT");
		driver.findElement(By.name("familyName")).sendKeys("TIGER");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("gender-field")).sendKeys("Male");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("birthdateDay-field")).sendKeys("11");
		driver.findElement(By.id("birthdateMonth-field")).sendKeys("May");
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1991");

		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("address1")).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("900055471211");

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

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
