package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;

public class VerifyTitle extends BaseTest {

	@Test
	public void verifyPageTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login");
	}

	@Test
	public void verifyPageURL() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://demo.openmrs.org/openmrs/login.htm");
	}
	
}
