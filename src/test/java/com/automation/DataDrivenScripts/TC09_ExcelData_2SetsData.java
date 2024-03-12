package com.automation.DataDrivenScripts;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC09_ExcelData_2SetsData extends BaseTest {

	// Excel Data - add poi-ooxml dependency in pom.xml for XLSX

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
	public Object[][] getTestData() throws EncryptedDocumentException, IOException {

		// Remove Hard Coding of data
//		Object[][] data = {
//				{ "Admin", "Admin123", "SCOTT", "TIGER", "MALE", "11", "MAY", "1991", "Hyderabad", "900023423422" },
//				{ "Admin", "Admin123", "SCOTT", "TIGER", "MALE", "12", "MAY", "1992", "Chennai", "9000555555555" },
//				{ "Admin", "Admin123", "SCOTT", "TIGER", "MALE", "13", "MAY", "1993", "DELHI", "9000666666666" }
//		};

		//2 rows , 10 columns defining in object array
		
		Object[][] data = new Object[2][10];

		File file = new File(
				"D:\\2023\\Automation\\Selenium\\Workplace_Apr\\OpenMRS\\src\\test\\resources\\OpenMRSLogin.xls");

		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		data[0][0] = sheet.getRow(0).getCell(0).toString();
		data[0][1] = sheet.getRow(0).getCell(1).toString();
		data[0][2] = sheet.getRow(0).getCell(2).toString();
		data[0][3] = sheet.getRow(0).getCell(3).toString();
		data[0][4] = sheet.getRow(0).getCell(4).toString();
		data[0][5] = sheet.getRow(0).getCell(5).toString();
		data[0][6] = sheet.getRow(0).getCell(6).toString();
		data[0][7] = sheet.getRow(0).getCell(7).toString();
		data[0][8] = sheet.getRow(0).getCell(8).toString();
		data[0][9] = sheet.getRow(0).getCell(9).toString();
		
		data[1][0] = sheet.getRow(1).getCell(0).toString();
		data[1][1] = sheet.getRow(1).getCell(1).toString();
		data[1][2] = sheet.getRow(1).getCell(2).toString();
		data[1][3] = sheet.getRow(1).getCell(3).toString();
		data[1][4] = sheet.getRow(1).getCell(4).toString();
		data[1][5] = sheet.getRow(1).getCell(5).toString();
		data[1][6] = sheet.getRow(1).getCell(6).toString();
		data[1][7] = sheet.getRow(1).getCell(7).toString();
		data[1][8] = sheet.getRow(1).getCell(8).toString();
		data[1][9] = sheet.getRow(1).getCell(9).toString();


		workbook.close();

		return data;
	}
}