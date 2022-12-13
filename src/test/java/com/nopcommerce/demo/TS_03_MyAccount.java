package com.nopcommerce.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.LoginPageObejct;
import pageObjects.MyAccountObject;
import pageObjects.RegisterPageObject;
import pageUls.MyAccountUI;
import utils.DataFakerUtil;

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
		myAccount.inputToLastNameTextbox("Nguyen");
		myAccount.inputToEmailTextbox("binh@gmail.com");
		myAccount.inputToCompanyTextbox("E");
		myAccount.clickToSaveButton();
		
		Assert.assertTrue(myAccount.isNewValueUpdateInfo("FirstName", "Binh1"));
		Assert.assertTrue(myAccount.isNewValueUpdateInfo("LastName", "Nguyen"));
		Assert.assertTrue(myAccount.isNewValueUpdateInfo("Email", "binh@gmail.com"));
		Assert.assertTrue(myAccount.isNewValueUpdateInfo("Company", "E"));
		
	}

	@Test
	public void TC_02_AddAdress() {
		myAccount.clickToAddressTab();
		myAccount.clickToAddNewButton();

		myAccount.inputToUpdateInfoAddressTextbox("FirstName","abc");
		myAccount.inputToUpdateInfoAddressTextbox("LastName","def");
		myAccount.inputToUpdateInfoAddressTextbox("Email","def@gmail.com");
		myAccount.inputToUpdateInfoAddressTextbox("PhoneNumber","0371234567");
		myAccount.inputToUpdateInfoAddressTextbox("FaxNumber","123-22222");
		myAccount.inputToUpdateInfoAddressTextbox("Company","A");
		myAccount.inputToUpdateInfoAddressTextbox("Address1","a1");
		myAccount.inputToUpdateInfoAddressTextbox("Address2","a2");
		myAccount.inputToUpdateInfoAddressTextbox("ZipPostalCode","87000");
		myAccount.inputToUpdateInfoAddressTextbox("City","My Tho");
		myAccount.enterTextToCountryDropdown("Viet Nam");
		BaseTest.sleepInSeconds(4);
		myAccount.clickToSaveAdressButton();
		
//		myAccount.inputToLastNameAddressTextbox("Huynh");
//		myAccount.inputToEmailAddressTextbox("atm@gmail.com");
//		myAccount.inputToCompanyAddressTextbox("autotest");
//		myAccount.enterTextToCountryDropdown("Viet Nam");
//		myAccount.enterTextToStateOrProvinceDropdown("Other");
//		myAccount.inputToCityAddressTextbox("My Tho");
//		myAccount.inputToAddress1Textbox("879c");
//		myAccount.inputToAddress2Textbox("home");
//		myAccount.inputToZipCodeOrPortalCodeAddressTextbox("87000");
//		myAccount.inputToPhoneNumberAddressTextbox("0371234567");
//		myAccount.inputToFaxNumberAddressTextbox("44-208-1234567");
		
		//Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("email", "def@gmail.com"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("phone", "0371234567"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("fax", "123-22222"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("company", "A"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("address1", "a1"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("address2", "a2"));
//		//Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("city-state-zip", "My Tho 87000"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo("country", "Viet Nam"));

		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo
				(MyAccountUI.PHONE_ADDRESS_TEXT, "0371234567"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo
//				(MyAccountUI.FAX_ADDRESS_TEXT, "123-22222"));
//		Assert.assertTrue(myAccount.isNewUpdateAdrressInfo
//				(MyAccountUI.COMPANY_ADDRESS_TEXT, "A"));
	}

	//@Test
	public void TC_03_UpdatePassword() {
		//driver.get(urlCustomerInfo);
		//Assert.assertTrue(loginPage.isLoged("My account"));
		myAccount.clickToChangePasswordTab();

		myAccount.inputToOldPassWordTextbox(GlobalContants.password);
		myAccount.inputToNewPassWordTextbox(GlobalContants.newPassword);
		myAccount.inputToConfirmNewPasswordTextbox(GlobalContants.newPassword);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myAccount.clickToChangePasswordButton();
		Assert.assertTrue(myAccount.isPassaWordChanged("Password was changed"));

	}
}
