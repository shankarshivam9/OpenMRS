package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureReports {
	
	//Open CMD  to the Project Location, then type command as below:
	// D:\2023\Automation\Selenium\Workplace_Apr\OpenMRS>allure serve
	
	@Test
	public void test1() {
		Assert.assertTrue(false);
		System.out.println("test1 is not working");
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(true);
		System.out.println("test1 is working");
	}

}
