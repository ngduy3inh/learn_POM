package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageUls.RegisterPageUI;
import pageUls.SearchPageUI;

public class SearchPageObject extends HeaderPageObject {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		super(driver);
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

	public boolean isAdvancedSearchChecked() {
		WebElement e = findElement(driver, SearchPageUI.ADVENCED_SEARCH_CHECKBOX);
		boolean checked = e.isSelected();
		return checked;
	}

	public void tickToAdvancedSearchCheckbox() {
		clickToElement(driver, SearchPageUI.ADVENCED_SEARCH_CHECKBOX);
	}
	//
	public void enterTextToCategoryDropdown(String value) {
		selectDropdownByText(driver, SearchPageUI.CATEGORY_DROPBOX, value);
	}
	
	public void enterTextToManufacturerDropdown(String value) {
		selectDropdownByText(driver, RegisterPageUI.DAY_DROPDOWN, value);
	}
	
//	public void chooseTextOfDropdown(String value) {
//		Select select = new Select(findElement(driver, SearchPageUI.CATEGORY_DROPBOX));
//		select.selectByVisibleText(value);
//	}

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
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_RESULTS_MESSAGE);
		return message.contains(value);

	}

	public boolean isAvancedSearchChecked(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_RESULTS_MESSAGE);
		return message.contains(value);
	}

	public boolean isVerifyKeysOfElements(String value) {
		List<WebElement> el = findElements(driver, SearchPageUI.PRODUCT_TITTLE_TEXT);
		boolean verify = true;
		for (WebElement o : el) {
			if (o.getText().contains(value)) {
				return verify = true;
			} else {
				return verify = false;
			}
		}
		return verify;
	}

}
