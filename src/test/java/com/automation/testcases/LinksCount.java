package com.automation.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

public class LinksCount extends BaseTest {

	@Test
	public void showLinksCount() {
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));

		int linkCount = linkElements.size();
		System.out.println("Total number of links on the page: " + linkCount);
	}
}
