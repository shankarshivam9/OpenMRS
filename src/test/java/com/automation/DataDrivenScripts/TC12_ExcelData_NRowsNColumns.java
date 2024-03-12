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

public class TC12_ExcelData_NRowsNColumns extends BaseTest {

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

		Object[][] data = null;
		File file = new File(
				"D:\\2023\\Automation\\Selenium\\Workplace_Apr\\OpenMRS\\src\\test\\resources\\OpenMRSLogin.xls");

		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		data = new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];

		for (int rowIndex = sheet.getFirstRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++) {

			for (int colIndex = sheet.getRow(0).getFirstCellNum(); colIndex < sheet.getRow(0)
					.getLastCellNum(); colIndex++) {
				data[rowIndex][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).toString();
			}

			workbook.close();

		}
		return data;
	}
}