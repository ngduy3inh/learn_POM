package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUls.LoginPageUI;

public class LoginPageObejct extends BasePage {
	WebDriver driver;

	// constructor
	public LoginPageObejct(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public void inputToPasswordTextbox(String password) {
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
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
	
	public boolean isHomePage(String value) {
		String message = getCurrentPageUrl(driver);
		return message.contains(value);
	}

	public void loginWithAccount(String email, String password) {
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		clickToLoginButton(); 
	}

}
