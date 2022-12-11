package com.nopcommerce.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.GlobalContants;
import pageObjects.LoginPageObejct;
import pageObjects.MyAccountObject;
import pageObjects.RegisterPageObject;
import pageUls.MyAccountUI;

public class TS_03_MyAccount {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	MyAccountObject myAccount;
	LoginPageObejct loginPage;
	RegisterPageObject registerPage;
	String urlRrgister = "https://demo.nopcommerce.com/register?returnUrl=%2F";
	String urlCustomerInfo = "https://demo.nopcommerce.com/customer/info";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new FirefoxDriver();
		loginPage = new LoginPageObejct(driver);
		myAccount = new MyAccountObject(driver);
		registerPage = new RegisterPageObject(driver);
		driver.get(urlCustomerInfo);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	@Test
	public void TC_01_UpdateInfo() {
		loginPage.loginWithAccount(GlobalContants.email, GlobalContants.password);
		Assert.assertTrue(loginPage.isLoged("My account"));
		driver.get(urlCustomerInfo);
		myAccount.inputToFistNameTextbox("Binh1");
		myAccount.inputToLastNameTextbox("Nguyen 1W");
		myAccount.inputToEmailTextbox("13binh1@gmail.com");
		myAccount.inputToCompanyTextbox("E.cc");

		myAccount.clickToSaveButton();
		Assert.assertTrue(myAccount.isNewUpdateInfo(MyAccountUI.FIRT_NAME_INFO_TEXTBOX, "Binh1"));
		Assert.assertTrue(myAccount.isNewUpdateInfo(MyAccountUI.LAST_NAME_INF0_TEXTBOX, "Nguyen 1W"));
		Assert.assertTrue(myAccount.isNewUpdateInfo(MyAccountUI.EMAIL_INFO_TEXTBOX, "13binh1@gmail.com"));
		Assert.assertTrue(myAccount.isNewUpdateInfo(MyAccountUI.COMPANY_INFO_TEXTBOX, "E.cc"));
	}

	@Test
	public void TC_02_AddAdress() {
		driver.get(urlCustomerInfo);
		loginPage.refeshCurrentPage(driver);
		Assert.assertTrue(loginPage.isLoged("My account"));

		myAccount.clickToAddressTab();
		myAccount.clickToAddNewButton();

		myAccount.inputToFirstNameAddressTextbox("Binh");
		myAccount.inputToLastNameAddressTextbox("Huynh");
		myAccount.inputToEmailAddressTextbox("atm0q111@gmail.com");
		myAccount.inputToCompanyAddressTextbox("autotest");
		myAccount.chooseToTextCountryAddressDropdown("Viet Nam");
		myAccount.chooseToTextStateOrProvinceAddressDropdown("Other");
		myAccount.inputToCityAddressTextbox("My Tho");
		myAccount.inputToAddress1Textbox("879c");
		myAccount.inputToAddress2Textbox("home");
		myAccount.inputToZipCodeOrPortalCodeAddressTextbox("87000");
		myAccount.inputToPhoneNumberAddressTextbox("0371234567");
		myAccount.inputToFaxNumberAddressTextbox("44-208-1234567");
		myAccount.clickToSaveAdressButton();

		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo(MyAccountUI.EMAIL_ADDRESS_TEXT, "atm0111@gmail.com"));
		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo(MyAccountUI.PHONE_ADDRESS_TEXT, "0371234567"));
		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo(MyAccountUI.FAX_ADDRESS_TEXT, "44-208-1234567"));
		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo(MyAccountUI.COMPANY_ADDRESS_TEXT, "autotest"));
	}

	@Test
	public void TC_03_UpdatePassword() {
		driver.get(urlCustomerInfo);
		Assert.assertTrue(loginPage.isLoged("My account"));
		myAccount.clickToChangePasswordTab();

		myAccount.inputToOldPassWordTextbox(GlobalContants.password);
		myAccount.inputToNewPassWordTextbox(GlobalContants.newPassword);
		myAccount.inputToConfirmNewPasswordTextbox(GlobalContants.newPassword);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myAccount.clickToChangePasswordButton();
		Assert.assertTrue(myAccount.isPassaWordChanged("Password was changed"));

	}
}
