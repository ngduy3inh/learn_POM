package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;
import pageUls.LoginPageUI;
import pageUls.MyAccountUI;
import pageUls.RegisterPageUI;

public class MyAccountObject extends BasePage {

	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}

/////////////////////Login/////////////////////
	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public boolean isEmailErrorMessage(String value) {
		String message = getTextOfElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return message.equals(value);
	}

	public boolean isLoginErrorMessage(String value) {
		String message = getTextOfElement(driver, LoginPageUI.LOGIN_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isLoged(String value) {
		String message = getTextOfElement(driver, LoginPageUI.MY_ACCOUNT_LINK);
		return message.contains(value);
	}

	public void loginWithAccount(String email, String password) {
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		clickToLoginButton();
	}

	public void clickToSaveButton() {
		clickToElement(driver, MyAccountUI.SAVE_INFO_BUTTON);
	}

/////////////////////Update Info/////////////////////
	public void clickToMaleRadioButton() {
		clickToElement(driver, RegisterPageUI.MALE_RADIO_BUTTON);
	}

	public void clickToFamaleRadioButton() {
		clickToElement(driver, RegisterPageUI.FAMALE_RADIO_BUTTON);
	}

	public void inputToFistNameTextbox(String firtName) {
		sendKeysToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firtName);
	}

	public void inputToLastNameTextbox(String lastName) {
		sendKeysToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToCompanyTextbox(String company) {
		sendKeysToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeysToElement(driver, RegisterPageUI.PASSSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public void chooseToTextDayDropdown(String day) {
		Select object = new Select(findElement(driver, RegisterPageUI.DAY_DROPDOWN));
		object.selectByVisibleText(day);
	}

	public void chooseToTextMonthDropdown(String month) {
		Select object = new Select(findElement(driver, RegisterPageUI.MONTH_DROPDOWN));
		object.selectByVisibleText(month);
	}

	public void chooseToTextYearDropdown(String year) {
		Select object = new Select(findElement(driver, RegisterPageUI.YEAR_DROPDOWN));
		object.selectByVisibleText(year);
	}
/////////////
	public boolean isUpdated(String value) {
		String message = getTextOfElement(driver, MyAccountUI.FIRT_NAME_INFO_TEXTBOX);
		return message.contains(value);
	}
	
	public boolean isNewValueUpdateInfo(String nameTextbox, String value) {
		String message = getAttributeValue
				(driver, MyAccountUI.UPDATE_INFO_TEXTBOX, "value" , nameTextbox);
		return message.contains(value);
	}
	
	public boolean isNewUpdateInfo(String nameAttribute, String nameTextbox, String value) {
		String message = getAttributeValue
				(driver, MyAccountUI.UPDATE_INFO_TEXTBOX, nameAttribute , nameTextbox);
		return message.contains(value);
	}

	public boolean isNewUpdateAdrressInfo(String locator, String value) {
		String message = getTextOfElement(driver, locator);
		return message.contains(value);
	}
	public boolean isUpdatedAdrressInfo(String name, String value) {
		String message = getTextOfElement(driver, MyAccountUI.UPDATED_ADDRESS_INFO, name);
		return message.contains(value);
	}
/////////////////////Address/////////////////////
	public void clickToSaveAdressButton() {
		clickToElement(driver, MyAccountUI.SAVE_ADDRESS_BUTTON);
	}

	public void clickToAddressTab() {
		clickToElement(driver, MyAccountUI.ADDRESSES_TAB);
	}

	public void clickToAddNewButton() {
		clickToElement(driver, MyAccountUI.ADD_NEW_BUTTON);
	}
/////////////
	public void inputToFirstNameAddressTextbox(String firtName) {
		sendKeysToElement(driver, MyAccountUI.FIRST_NAME_ADDRESS_TEXTBOX, firtName);
	}

	public void inputToLastNameAddressTextbox(String lastname) {
		sendKeysToElement(driver, MyAccountUI.LAST_NAME_ADDRESS_TEXTBOX, lastname);
	}

	public void inputToEmailAddressTextbox(String email) {
		sendKeysToElement(driver, MyAccountUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCityAddressTextbox(String city) {
		sendKeysToElement(driver, MyAccountUI.CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address1) {
		sendKeysToElement(driver, MyAccountUI.ADDRESS1_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		sendKeysToElement(driver, MyAccountUI.ADDRESS2_TEXTBOX, address2);
	}

	public void inputToZipCodeOrPortalCodeAddressTextbox(String zipcodeOrPortalcode) {
		sendKeysToElement(driver, MyAccountUI.ZIP_OR_POSTAL_CODE_TEXTBOX, zipcodeOrPortalcode);
	}

	public void inputToPhoneNumberAddressTextbox(String phoneNumber) {
		sendKeysToElement(driver, MyAccountUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberAddressTextbox(String faxNumber) {
		sendKeysToElement(driver, MyAccountUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void inputToCompanyAddressTextbox(String company) {
		sendKeysToElement(driver, MyAccountUI.COMPANY_TEXTBOX, company);
	}
	
	public void inputToUpdateInfoAddressTextbox(String nameTextbox, String value) {
		sendKeysToElement(driver, MyAccountUI.UPDATE_INFO_ADDRESS_TEXTBOX, value, nameTextbox);
	}
////////////
	public void enterTextToCountryDropdown(String value) {
		selectDropdownByText(driver, MyAccountUI.COUNTRY_DROPDOWN, value);
	}

	public void enterTextToStateOrProvinceDropdown(String value) {
		selectDropdownByText(driver, MyAccountUI.STATE_OR_PROVINCE_DROPDOWN, value);
	}

/////////////////////Change password/////////////////////
	public void clickToChangePasswordTab() {
		clickToElement(driver, MyAccountUI.CHANGE_PASSWORD_TAB);
	}

	public void inputToOldPassWordTextbox(String oldPassword) {
		sendKeysToElement(driver, MyAccountUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void inputToNewPassWordTextbox(String newPassword) {
		sendKeysToElement(driver, MyAccountUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputToConfirmNewPasswordTextbox(String confirmPassword) {
		sendKeysToElement(driver, MyAccountUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToChangePasswordButton() {
		clickToElement(driver, MyAccountUI.CHANGE_PASSWORD_BUTTON);
	}

	public boolean isPassaWordChanged(String value) {
		String message = getTextOfElement(driver, MyAccountUI.PASSOWRD_CHANGED_NOTIFICATION);
		return message.contains(value);

	}

}
