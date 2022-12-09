package com.nopcommerce.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import common.GlobalContants;
import pageObjects.RegisterPageObject;

public class TS_01_Register extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	RegisterPageObject registerPage;
	String url = "https://demo.nopcommerce.com/register?returnUrl=%2F";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		registerPage = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass(){
		driver.quit();
	}

	@Test
	public void TC_01_RegisterWithEmtyData() {
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isFirstNameErrorMessage("First name is required."));
		Assert.assertTrue(registerPage.isLastNameErrorMessage("Last name is required."));
		Assert.assertTrue(registerPage.isEmailErrorMessage("Email is required."));
		Assert.assertTrue(registerPage.isPasswordErrorMessage("Password is required."));
		Assert.assertTrue(registerPage.isPasswordErrorMessage("Password is required."));
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.refeshCurrentPage(driver);
		registerPage.inputToEmailTextbox(GlobalContants.wrongEmail);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isEmailErrorMessage("Wrong email"));
	}

	@Test
	public void TC_03_RegisterWithIfCorrect() {

		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(GlobalContants.firtName);
		registerPage.inputToLastNameTextbox(GlobalContants.lastName);
		registerPage.chooseToTextDayDropdown(GlobalContants.day);
		registerPage.chooseToTextMonthDropdown(GlobalContants.month);
		registerPage.chooseToTextYearDropdown(GlobalContants.year);
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.password);

		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterComplete("Your registration completed"));
	}

	@Test
	public void TC_04_RegisterWithEmailExist() {
		openUrl(driver, url);
		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(GlobalContants.firtName);
		registerPage.inputToLastNameTextbox(GlobalContants.lastName);
		registerPage.chooseToTextDayDropdown(GlobalContants.day);
		registerPage.chooseToTextMonthDropdown(GlobalContants.month);
		registerPage.chooseToTextYearDropdown(GlobalContants.year);
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.password);

		registerPage.clickToRegisterButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(registerPage.isEmailAlreadyExistErrorMessage("The specified email already exists"));
	}

	@Test
	public void TC_05_RegisterWithPasswordLessThan6Characters() {
		openUrl(driver, url);
		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(GlobalContants.firtName);
		registerPage.inputToLastNameTextbox(GlobalContants.lastName);
		registerPage.chooseToTextDayDropdown(GlobalContants.day);
		registerPage.chooseToTextMonthDropdown(GlobalContants.month);
		registerPage.chooseToTextYearDropdown(GlobalContants.year);
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.passwordLessThan6Characters);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.passwordLessThan6Characters);
		
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isPasswordErrorMessage("Password must meet the following rules:"));
		Assert.assertTrue(registerPage.isPasswordErrorMessage("must have at least 6 characters"));
	}

	@Test
	public void TC_06_RegisterWithPasswordNotMath() {
		openUrl(driver, url);
		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(GlobalContants.firtName);
		registerPage.inputToLastNameTextbox(GlobalContants.lastName);
		registerPage.chooseToTextDayDropdown(GlobalContants.day);
		registerPage.chooseToTextMonthDropdown(GlobalContants.month);
		registerPage.chooseToTextYearDropdown(GlobalContants.year);
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.passwordLessThan6Characters);
		
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isConfirmNotMatchErrorMessage("The password and confirmation password do not match."));
	
	}

}
