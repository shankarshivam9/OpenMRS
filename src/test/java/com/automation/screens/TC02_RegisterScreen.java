package com.automation.screens;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC02_RegisterScreen {

	@FindBy(partialLinkText = "Register a patient")
	private WebElement lnkRegister = null;

	@FindBy(name = "givenName")
	private WebElement txtFirstName = null;

	@FindBy(name = "familyName")
	private WebElement txtLastName = null;

	@FindBy(id = "next-button")
	private WebElement btnNext = null;

	@FindBy(id = "gender-field")
	private WebElement gender = null;

	@FindBy(id = "birthdateDay-field")
	private WebElement txtDay = null;

	@FindBy(id = "birthdateMonth-field")
	private WebElement txtMonth = null;

	@FindBy(id = "birthdateYear-field")
	private WebElement txtYear = null;

	@FindBy(id = "address1")
	private WebElement txtAddress = null;

	@FindBy(name = "phoneNumber")
	private WebElement txtMobileNumber = null;

	@FindBy(id = "submit")
	private WebElement btnConfirm = null;

	@FindBy(xpath = "//em[text()='Patient ID']/../span")
	private WebElement getPatientId = null;

	private WebDriver driver;

	public TC02_RegisterScreen(WebDriver driver) {
		this.driver = driver; // Initialize the driver in the constructor
		PageFactory.initElements(driver, this);
	}


	public void register() throws Exception {
		lnkRegister.click();
		txtFirstName.sendKeys("SCOTT");
		txtLastName.sendKeys("TIGER");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
		gender.sendKeys("MALE");

		wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
		txtDay.sendKeys("11");
		txtMonth.sendKeys("MAY");
		txtYear.sendKeys("1986");

		wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
		txtAddress.sendKeys("Hyderabad");

		wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
		txtMobileNumber.sendKeys("900055471211");

		wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
		wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
		btnConfirm.click();

		System.out.println(getPatientId.getText());
	}
}