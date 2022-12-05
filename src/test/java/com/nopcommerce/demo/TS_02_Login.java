package com.nopcommerce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.LoginPageObejct;

//test suit tap hop nhieu test case
public class TS_02_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageObejct loginPage;

	@BeforeClass
	public void beforeClass() {
		String url = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new FirefoxDriver();
		loginPage = new LoginPageObejct(driver);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
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
		loginPage.inputToEmailTextbox(GlobalContants.wrong_email);
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
		loginPage.clickToLoginButton();
		Assert.assertTrue(
				loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_LoginWithRegisteredEmailAndInvalidPassword() {
		loginPage.loginWithAccount(GlobalContants.RegisteredEmail, GlobalContants.invalidPassword);
		loginPage.clickToLoginButton();
		Assert.assertTrue(
				loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_LoginWithValidAccount() {
		loginPage.loginWithAccount(GlobalContants.RegisteredEmail, GlobalContants.password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoged("My account"));
	}
}
