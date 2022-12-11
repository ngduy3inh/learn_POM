package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUls.HeaderPageUI;

public class HeaderPageObject extends BasePage {
	WebDriver driver;
	public HeaderPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickToLabelOfMenu(String nameLabel) {
		clickToElement(driver, HeaderPageUI.MENU_LABEL, nameLabel);
	}
}
