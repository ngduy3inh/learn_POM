package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageUls.RegisterPageUI;

public class RegisterPageObject extends HeaderPageObject {
	WebDriver driver;
	// constructor
	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	

/////////////////////////////////////
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

	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
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
////////////

	public void enterTextToDayDropdown(String value) {
		selectDropdownByText(driver, RegisterPageUI.DAY_DROPDOWN, value);
	}

	public void enterTextToMonthDropdown(String value) {
		selectDropdownByText(driver, RegisterPageUI.MONTH_DROPDOWN, value);
	}

	public void enterTexToYearDropdown(String value) {
		selectDropdownByText(driver, RegisterPageUI.YEAR_DROPDOWN, value);
	}

/////dyamic 
	public boolean isErrorMessage(String nameMessage, String value) {
		String message = getTextOfElement(driver, RegisterPageUI.REQUIRED_ERROR_MESSAGE, nameMessage);
		return message.contains(value);
	}
////
	public boolean isRegisterComplete(String value) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_COMPLETE_TEXT_MESSAGE);
		String message = getTextOfElement(driver, RegisterPageUI.REGISTER_COMPLETE_TEXT_MESSAGE);
		return message.contains(value);

	}

	public boolean isEmailAlreadyExistErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.EMAIL_ALREADY_EXIST_ERROR_MESSAGE);
		return message.contains(value);

	}
}
