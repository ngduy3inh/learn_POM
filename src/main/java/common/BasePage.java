package common;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// tai' sd, selenium
public class BasePage {
	private Select select;

	// getter
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	/////////////////////////////////
	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return findElement(driver, locator);
	}

	//////////////////////
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public By getByXpath(String locator, String... params) {
		return By.xpath(String.format(locator, (Object[]) params));
	}

////findElement
	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public WebElement findElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(locator, params));
	}

	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));

	}

////getText
	public String getTextOfElement(WebDriver driver, String locator) {
		return findElement(driver, locator).getText();
	}

	public String getTextOfElement(WebDriver driver, String locator, String... params) {
		return findElement(driver, locator, params).getText();
	}

////getValue
	public String getValue(WebDriver driver, String locator) {
		WebElement l = findElement(driver, locator);
		String val = l.getAttribute("value");
		return val;
	}

////sendkey
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		findElement(driver, locator).clear();
		findElement(driver, locator).sendKeys(valueInput);
	}

////click
	public void clickToElement(WebDriver driver, String locator) {
		findElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... params) {
		findElement(driver, locator, params).click();
	}

////dropdown
	public void selectDropdownByText(WebDriver driver, String locator, String textItem) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(textItem);
	}
}
