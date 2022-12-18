package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.LoginPageObejct;
import pageObjects.MyAccountObject;
import pageObjects.RegisterPageObject;
import reportConfigV5.ExtentTestManager;
import utils.DataFakerUtil;

public class TS_03_MyAccount extends BaseTest{
	WebDriver driver;
	MyAccountObject myAccount;
	LoginPageObejct loginPage;
	RegisterPageObject registerPage;
	String urlCustomerInfo = "https://demo.nopcommerce.com/customer/info";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String nameBrowser) {
		driver = getBrowserDriver(nameBrowser, urlCustomerInfo);

		loginPage = new LoginPageObejct(driver);
		myAccount = new MyAccountObject(driver);
		registerPage = new RegisterPageObject(driver);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_UpdateInfo() {
		ExtentTestManager.startTest("Update Info", "");
		myAccount.loginWithAccount(GlobalContants.email, GlobalContants.password);
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
	public void TC_02_AddAddress() {
		ExtentTestManager.startTest("Add Address", "");
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
		myAccount.clickToSaveAdressButton();
		
		Assert.assertTrue(myAccount.isNewUpdateAddressInfo("email", "def@gmail.com"));
		Assert.assertTrue(myAccount.isNewUpdateAddressInfo("phone", "0371234567"));
		Assert.assertTrue(myAccount.isNewUpdateAddressInfo("fax", "123-22222"));
		Assert.assertTrue(myAccount.isNewUpdateAddressInfo("address1", "a1"));
		Assert.assertTrue(myAccount.isNewUpdateAddressInfo("address2", "a2"));
		Assert.assertTrue(myAccount.isNewUpdateAddressInfo("city-state-zip", "87000"));
		Assert.assertTrue(myAccount.isNewUpdateAddressInfo("country", "Viet Nam"));
	}

	@Test
	public void TC_03_UpdatePassword() {
		ExtentTestManager.startTest("Update Password", "");
		myAccount.clickToChangePasswordTab();

		myAccount.inputToOldPassWordTextbox(GlobalContants.password);
		myAccount.inputToNewPassWordTextbox(GlobalContants.newPassword);
		myAccount.inputToConfirmNewPasswordTextbox(GlobalContants.newPassword);
		myAccount.clickToChangePasswordButton();
		Assert.assertTrue(myAccount.isPassaWordChanged("Password was changed"));
		
		myAccount.clickToCloseNotifiCationAdded();
		myAccount.clickToLabelOfMenu("logout");
		myAccount.clickToLabelOfMenu("login");
		myAccount.loginWithAccount(GlobalContants.email, GlobalContants.password);
		Assert.assertTrue(myAccount.isLoginErrorMessage
				("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(myAccount.isLoginErrorMessage
				("The credentials provided are incorrect"));
		myAccount.loginWithAccount(GlobalContants.email, GlobalContants.newPassword);
		Assert.assertTrue(loginPage.isUrlHomePage("https://demo.nopcommerce.com/"));
	}
}
