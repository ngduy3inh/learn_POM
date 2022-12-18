package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.RegisterPageObject;
import reportConfigV5.ExtentTestManager;
import utils.DataFakerUtil;

public class TS_01_Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	DataFakerUtil dataFaker;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsweName) {
		String url = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		driver = getBrowserDriver(browsweName, url);
		
		registerPage = new RegisterPageObject(driver);
		dataFaker = DataFakerUtil.getData();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_RegisterWithEmtyData() {
		ExtentTestManager.startTest("register", "");
		
		ExtentTestManager.getTest().log(Status.INFO, " click to register");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, " verify info");
		Assert.assertTrue(registerPage.isErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("Email", "Email is required."));
		Assert.assertTrue(registerPage.isErrorMessage("Password", "Password is required."));
		Assert.assertTrue(registerPage.isErrorMessage("ConfirmPassword", "Password is required."));

	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		ExtentTestManager.startTest("register with invalid email", "");
		registerPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, " enter email: " + GlobalContants.wrongEmail);
		registerPage.inputToEmailTextbox(GlobalContants.wrongEmail);
		ExtentTestManager.getTest().log(Status.INFO, " click to register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify erro message");
		Assert.assertTrue(registerPage.isErrorMessage("Email", "Wrong email"));
	}

	@Test
	public void TC_03_RegisterWithIfCorrect() {
		ExtentTestManager.startTest("register with Correct", "");
		registerPage.refeshCurrentPage(driver); 
		
		ExtentTestManager.getTest().log(Status.INFO, "enter info");
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox("company A");
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.password);

		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify message");
		Assert.assertTrue(registerPage.isRegisterComplete("Your registration completed"));
		registerPage.clickToLabelOfMenu("logout");
		
	}

	@Test
	public void TC_04_RegisterWithEmailExist() {
		ExtentTestManager.startTest("Register With Email Exist,", "");
		registerPage.clickToLabelOfMenu("register");
		registerPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "enter info");
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox("company A");
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.password);
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify erro message");
		Assert.assertTrue(registerPage.isEmailAlreadyExistErrorMessage
				("The specified email already exists"));
	}

	@Test
	public void TC_05_RegisterWithPasswordLessThan6Characters() {
		ExtentTestManager.startTest("Register With Password Less Than 6 Characters", "");
		registerPage.clickToLabelOfMenu("register");
		registerPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "enter info");
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox("company A");
		registerPage.inputToPasswordTextbox(GlobalContants.passwordLessThan6Characters);
		registerPage.inputToConfirmPasswordTextbox(GlobalContants.passwordLessThan6Characters);
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify erro message");
		Assert.assertTrue(registerPage.isErrorMessage
				("Password", "Password must meet the following rules:"));
		Assert.assertTrue(registerPage.isErrorMessage
				("Password", "must have at least 6 characters"));
	}

	@Test
	public void TC_06_RegisterWithPasswordNotMath() {
		ExtentTestManager.startTest("Register With Password Not Math", "");
		registerPage.clickToLabelOfMenu("register");
		
		ExtentTestManager.getTest().log(Status.INFO, "enter info");
		registerPage.refeshCurrentPage(driver);
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFistNameTextbox(dataFaker.getFirstName());
		registerPage.inputToLastNameTextbox(dataFaker.getLastName());
		registerPage.enterTextToDayDropdown("1");
		registerPage.enterTextToMonthDropdown("June");
		registerPage.enterTexToYearDropdown("2002");
		registerPage.inputToEmailTextbox(GlobalContants.email);
		registerPage.inputToCompanyTextbox("company A");
		registerPage.inputToPasswordTextbox(GlobalContants.password);
		registerPage.inputToConfirmPasswordTextbox("2");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify erro message");
		Assert.assertTrue(registerPage.isErrorMessage
				("ConfirmPassword", "The password and confirmation password do not match."));

	}

}
