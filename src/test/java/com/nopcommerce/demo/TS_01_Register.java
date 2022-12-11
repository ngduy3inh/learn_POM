package com.nopcommerce.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.GlobalContants;
import pageObjects.HeaderPageObject;
import pageObjects.RegisterPageObject;
import pageUls.RegisterPageUI;
import utils.DataFakerUtil;

public class TS_01_Register extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	RegisterPageObject registerPage;
	DataFakerUtil dataFaker;
	HeaderPageObject headerPage;
	String url = "https://demo.nopcommerce.com/register?returnUrl=%2F";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		registerPage = new RegisterPageObject(driver);
		dataFaker = DataFakerUtil.getData();
		headerPage = new HeaderPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_RegisterWithEmtyData() {
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("Email", "Email is required."));
		Assert.assertTrue(registerPage.isErrorMessage("Password", "Password is required."));
		Assert.assertTrue(registerPage.isErrorMessage("ConfirmPassword", "Password is required."));

//		Assert.assertTrue(registerPage.isFirstNameErrorMessage("First name is required."));
//		Assert.assertTrue(registerPage.isLastNameErrorMessage("Last name is required."));
//		Assert.assertTrue(registerPage.isEmailErrorMessage("Email is required."));
//		Assert.assertTrue(registerPage.isPasswordErrorMessage("Password is required."));
//		Assert.assertTrue(registerPage.isPasswordErrorMessage("Password is required."));
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.refeshCurrentPage(driver);
		registerPage.inputToEmailTextbox(GlobalContants.wrongEmail);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isErrorMessage("Email", "Wrong email"));
		Assert.assertTrue(registerPage.isEmailErrorMessage("Wrong email"));
	}

	@Test
	public void TC_03_RegisterWithIfCorrect() {
		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.password);

		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterComplete("Your registration completed"));
		headerPage.clickToLabelOfMenu("logout");
		BaseTest.sleepInSeconds(2);
	}

	@Test
	public void TC_04_RegisterWithEmailExist() {
		headerPage.clickToLabelOfMenu("register");

		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.password);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isEmailAlreadyExistErrorMessage
				("The specified email already exists"));
	}

	@Test
	public void TC_05_RegisterWithPasswordLessThan6Characters() {
		headerPage.clickToLabelOfMenu("register");
		
		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.passwordLessThan6Characters);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.passwordLessThan6Characters);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isErrorMessage
				("Password", "Password must meet the following rules:"));
		Assert.assertTrue(registerPage.isErrorMessage
				("Password", "must have at least 6 characters"));

//		Assert.assertTrue(registerPage.isPasswordErrorMessage("Password must meet the following rules:"));
//		Assert.assertTrue(registerPage.isPasswordErrorMessage("must have at least 6 characters"));
	}

	@Test
	public void TC_06_RegisterWithPasswordNotMath() {
		headerPage.clickToLabelOfMenu("register");
		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox(GlobalContants.company);
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox("2");
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isErrorMessage
				("ConfirmPassword", "The password and confirmation password do not match."));
//		Assert.assertTrue(
//				registerPage.isConfirmNotMatchErrorMessage("The password and confirmation password do not match."));

	}

}
