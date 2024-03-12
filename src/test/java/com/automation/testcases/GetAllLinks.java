package com.automation.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

public class GetAllLinks extends BaseTest {

	@Test
	public void displayLinks() {
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		
		// Iterate through each link element and print the href attribute
		for (WebElement element : linkElements) {
			String linkURL = element.getAttribute("href");
			System.out.println("Links : \n" + linkURL);
		}
	}
}
