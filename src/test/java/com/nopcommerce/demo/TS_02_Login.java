package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.LoginPageObejct;

//test suit tap hop nhieu test case
public class TS_02_Login extends BaseTest {
	WebDriver driver;
	// String projectPath = System.getProperty("user.dir");
	LoginPageObejct loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		driver = getBrowserDriver("chrome", "https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObejct(driver);

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPage.refeshCurrentPage(driver);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMessage("Please enter your email"));
	}

	@Test
	public void TC_02_LoginWithInvalidData() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextbox(GlobalContants.wrongEmail);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMessage("Wrong email"));
	}

	@Test
	public void TC_03_LoginWithUnregisteredEmail() {
		loginPage.refeshCurrentPage(driver);
		loginPage.inputToEmailTextbox(GlobalContants.unregisteredEmail);
		loginPage.clickToLoginButton();
		Assert.assertTrue(
				loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("No customer account found"));
	}

	@Test
	public void TC_04_LoginWithRegisteredEmailAndPasswordEmpty() {
		loginPage.loginWithAccount(GlobalContants.RegisteredEmail, "");
		Assert.assertTrue(
				loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_LoginWithRegisteredEmailAndInvalidPassword() {
		loginPage.loginWithAccount(GlobalContants.RegisteredEmail, GlobalContants.invalidPassword);
		Assert.assertTrue(
				loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_LoginWithValidAccount() {
		loginPage.loginWithAccount(GlobalContants.RegisteredEmail, GlobalContants.password);
		Assert.assertTrue(loginPage.isLoged("My account"));
	}
}
