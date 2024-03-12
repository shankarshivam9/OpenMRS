package com.automation.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected static WebDriver driver = null;
	public static Properties prop = new Properties();
	public static FileReader fileReader;

	@BeforeTest
	public void openBrowser() throws IOException {

		if (driver == null) {
			FileReader fileReader = new FileReader(
					"D:\\2023\\Automation\\Selenium\\Workplace_Apr\\OpenMRS\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fileReader);

		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

//		driver = new ChromeDriver();
//		driver.get("https://demo.openmrs.org/openmrs/login.htm");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
