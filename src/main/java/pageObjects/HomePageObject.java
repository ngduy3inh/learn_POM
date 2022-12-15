package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUls.HeaderPageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickLabelOfMenu(String loc) {
		clickToElement(driver, null);
	}
	public void clickTiLoginLabelMenu() {
		clickToElement(driver, HeaderPageUI.LOGIN_LABEL);
	}
}
