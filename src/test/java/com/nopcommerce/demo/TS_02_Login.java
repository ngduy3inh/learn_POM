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
import pageObjects.LoginPageObejct;
import reportConfigV5.ExtentTestManager;
import utils.DataFakerUtil;

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObejct loginPage;
	DataFakerUtil dataFaker;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		
		loginPage = new LoginPageObejct(driver);
		dataFaker = DataFakerUtil.getData();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_LoginWithEmptyData() {
		ExtentTestManager.startTest("Login With Empty Data", "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: click register button without input anything");
		
		loginPage.refeshCurrentPage(driver);
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: verify error message");
		Assert.assertTrue(loginPage.isEmailErrorMessage("Please enter your email"));
	}

	@Test
	public void TC_02_LoginWithInvalidData() {
		ExtentTestManager.startTest("Login With Invalid Data", "");
		loginPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "input email: " + GlobalContants.wrongEmail);
		loginPage.inputToEmailTextbox(GlobalContants.wrongEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "click login");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify error message");
		Assert.assertTrue(loginPage.isEmailErrorMessage("Wrong email"));
	}

	@Test
	public void TC_03_LoginWithUnregisteredEmail() {
		ExtentTestManager.startTest("Login With Unregistered Email", "");
		loginPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "input email");
		loginPage.inputToEmailTextbox(dataFaker.getEmail());
		
		ExtentTestManager.getTest().log(Status.INFO, "click login");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify error message");
		Assert.assertTrue(loginPage.isLoginErrorMessage
				("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("No customer account found"));
	}

	@Test
	public void TC_04_LoginWithRegisteredEmailAndPasswordEmpty() {
		loginPage.loginWithAccount(GlobalContants.email, "");
		Assert.assertTrue(loginPage.isLoginErrorMessage
				("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_LoginWithRegisteredEmailAndInvalidPassword() {
		ExtentTestManager.startTest("Login With Registered Email And Invalid Password", "");
		
		ExtentTestManager.getTest().log(Status.INFO, "login");
		loginPage.loginWithAccount(GlobalContants.email, GlobalContants.invalidPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "verify error message");
		Assert.assertTrue(loginPage.isLoginErrorMessage
				("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage
				("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_LoginWithValidAccount() {
		ExtentTestManager.startTest("Login With Valid Account", "");
		
		ExtentTestManager.getTest().log(Status.INFO, "login");
		loginPage.loginWithAccount(GlobalContants.email, GlobalContants.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "verify login success");
		Assert.assertTrue(loginPage.isUrlHomePage("https://demo.nopcommerce.com/"));
		Assert.assertTrue(loginPage.isLoged("My account"));
	}
}
