package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUls.HeaderPageUI;
import pageUls.LoginPageUI;

public class HeaderPageObject extends BasePage {
	WebDriver driver;

	public HeaderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLabelOfMenu(String nameLabel) {
		clickToElement(driver, HeaderPageUI.MENU_LABEL, nameLabel);
	}

	public void hoverToElementOfTopMenu() {
		hoverToElement(driver, HeaderPageUI.TOP_MENU_ELECTRO);
	}

	public void clickToLogout() {
		waitForElementVisible(driver, HeaderPageUI.LOGOUT_LABEL);
		clickToElement(driver, HeaderPageUI.LOGOUT_LABEL);
	}
	
	public void clickToLoginLabelMenu() {
		clickToElement(driver, HeaderPageUI.LOGIN_LABEL);
	}
}
