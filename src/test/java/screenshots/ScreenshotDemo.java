package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
		String actualResult = driver.getTitle();

		// Take a screenshot and save it to a file
		takeScreenshot(driver, "screenshot.png");
	}

	// Method to take a screenshot and save it to a file
	public static void takeScreenshot(WebDriver driver, String fileName) {
		// Convert the WebDriver instance to TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Capture the screenshot as a file
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

		// Specify the location to save the screenshot
		File destinationFile = new File(fileName);

		try {
			// Copy the captured screenshot to the specified location
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error occurred while saving the screenshot: " + e.getMessage());
		}

	}

}
