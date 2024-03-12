package com.automation.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	// Need 2 classes for reports - ExtentReports , ExtentSparkReporter

	ExtentReports extentReports;
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\ExtentReports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Extent Reports_DAZN");

		 extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Tester", "Shankar");
	}

	@Test
	public void createReport_GetTitle() {
		ExtentTest extentTest = extentReports.createTest("Create_Report Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.close();
		//extentTest.addScreenCaptureFromBase64String(null);
	//	extentTest.fail("Result does not match");
	
		extentReports.flush();
	}

}
