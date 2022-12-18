package pageObjectsdataTable;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIsdataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageNumber(String number) {
		waitForClickable(driver, HomePageUI.PAGING_BY_NUMBER, number);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, number);
	}

	public boolean isPageActivedPageNumber(String number) {
		// waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVED, number);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVED, number);
	}

	public void inputToHeaderTextboxByName(String headerName, String value) {
		sendKeysToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElenment(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public boolean isRowValueDisplay(String female, String country, String males, String total) {
		return isElementDisplayed(driver, HomePageUI.ROW, female, country, males, total);

	}

	public void clickByIconCountryName(String countryName, String iconAction) {
		waitForClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
	}
	
	public boolean isDataRemoved(String female, String country, String males, String total) {
		return isElementExist(driver, HomePageUI.ROW, female, country, males, total);
	}

}
//td[@data-key='females' and text()= '12253515']//following-sibling::td[@data-key='country' and text()='AFRICA']//following-sibling::td[@data-key='males' and text()='12599691' ]//following-sibling::td[@data-key='total' and text()='24853148']
