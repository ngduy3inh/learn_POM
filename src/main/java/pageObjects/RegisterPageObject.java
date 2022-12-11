package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;
import pageUls.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public RegisterPageObject(WebDriver driver) {
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
	
	public void clickToLogoutButton() {
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
	}

	public void chooseToTextDayDropdown(String day) {
		Select object = new Select(findElement(driver, RegisterPageUI.DAY_DROPDOWN));
		object.selectByVisibleText(day);
	}

	public void chooseToTextMonthDropdown(String day) {
		Select object = new Select(findElement(driver, RegisterPageUI.MONTH_DROPDOWN));
		object.selectByVisibleText(day);
	}

	public void chooseToTextYearDropdown(String day) {
		Select object = new Select(findElement(driver, RegisterPageUI.YEAR_DROPDOWN));
		object.selectByVisibleText(day);
	}
/////////////////////////////////////
	public boolean isFirstNameErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.FIRT_NAME_ERROR_MESSAGE);
		return message.equals(value);
	}

	public boolean isLastNameErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return message.equals(value);
	}

	public boolean isEmailErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return message.equals(value);
	}

	public boolean isPasswordErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return message.contains(value);
	}

	public boolean isConfirmNotMatchErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.PASSWORD_NOT_MATCH_ERROR_MESSAGE);
		return message.contains(value);
	}
	public boolean isRegisterComplete(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.REGISTER_COMPLETE_TEXT_MESSAGE);
		return message.contains(value);

	}

	public boolean isEmailAlreadyExistErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.EMAIL_ALREADY_EXIST_ERROR_MESSAGE);
		return message.contains(value);

	}
}
