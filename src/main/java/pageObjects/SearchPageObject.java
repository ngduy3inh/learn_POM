package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;
import pageUls.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchKeywordTextbox(String value) {
		sendKeysToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public boolean isMiniumLengthCharacters(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_RESULTS_MESSAGE);
		return message.contains(value);
	}

//	public String getTextOfListElement() {
//		List<WebElement> list = driver.findElements(SearchPageUI.PRODUCT_TITTLE_TEXT);
//		return null;
//		
//	}
	public boolean isAdvancedSearchChecked() {
		WebElement e = findElement(driver, SearchPageUI.ADVENCED_SEARCH_CHECKBOX);
		boolean checked = e.isSelected();
		return true;

	}

	public void tickToAdvancedSearchCheckbox() {
		clickToElement(driver, SearchPageUI.ADVENCED_SEARCH_CHECKBOX);
	}

	public void chooseTextOfDropdown(String value) {
		Select select = new Select(findElement(driver, SearchPageUI.CATEGORY_DROPBOX));
		select.selectByVisibleText(value);
	}

	public void tickToAutomaticallySearchSubCategories() {
		clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
	}

	public boolean isAutomaticallyChecked() {
		WebElement e = findElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
		boolean checked = e.isSelected();
		return true;
	}

	public void tickToSearchInProductDescriptions() {
		clickToElement(driver, SearchPageUI.SEARCH_IN_PRODUCT_DESSCRIPTIONS_CHECKBOX);
	}

	public boolean isNotProduct(String value) {
		String message = findElement(driver, SearchPageUI.SEARCH_RESULTS_MESSAGE).getText();
		return message.contains(value);

	}

	public boolean isAvancedSearchChecked(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_RESULTS_MESSAGE);
		return message.contains(value);
	}

	public boolean isVerifyElementsOfKeys(WebDriver driver, String locator, String value) {
		String text = "";
		List<WebElement> el = driver.findElements(By.xpath(locator));
		for (WebElement o : el) {
			text = o.getText();
		}
		return text.contains(value);
	}

}
