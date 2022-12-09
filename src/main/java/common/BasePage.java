package common;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// tai' sd, selenium
public class BasePage {
	
	List<Element> e;

	// getter
	public static BasePage getBasePage() {
		return new BasePage();
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
	
	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	//////////////////////
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
		
	}
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		findElement(driver, locator).clear();
		findElement(driver, locator).sendKeys(valueInput);
	}

	public void clickToElement(WebDriver driver, String locator) {
		findElement(driver, locator).click();
	}

	public String getTextOfElement(WebDriver driver, String locator) {
		return findElement(driver, locator).getText();
	}
	public String getValue(WebDriver driver, String locator) {
		WebElement l = findElement(driver, locator);
		String val = l.getAttribute("value");
		return val;
	}
}
