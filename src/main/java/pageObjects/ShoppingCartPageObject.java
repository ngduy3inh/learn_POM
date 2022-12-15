package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUls.ShoppingCartUI;
import pageUls.WishListUI;

public class ShoppingCartPageObject extends HeaderPageObject {
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean isNameProductAdded(String value) {
		String message = getTextOfElement(driver, WishListUI.PRODUCT_NAME_TEXT);
		return message.contains(value);
	}
	
	public void clickToShoppingCartLabel() {
		clickToElement(driver, ShoppingCartUI.SHOPPING_CART_LABEL);
	}
	
	public void inputQuantity(String valueInput) {
		sendKeysToElement(driver, ShoppingCartUI.QUANTITY_MACBOOK_TEXTBOX, valueInput);
	}
	
	public void clickToUpdateShoppingCartButton() {
		clickToElement(driver, ShoppingCartUI.UPDATE_SHOPPING_CART_BUTTON);
	}
	
	public boolean isUpdatedQuantityMacbook(String value) {
		String message = getAttributeValue(driver, ShoppingCartUI.QUANTITY_MACBOOK_TEXTBOX, "value");
		return message.contains(value);
	}
	
	public void clickToRemoveProductMacbook() {
		clickToElement(driver, ShoppingCartUI.REMOVE_MACBOOK_SHOPPING_CART_BUTTON);
	}
	
	public boolean isShoppingCartEmpty(String value) {
		String message = getTextOfElement(driver, ShoppingCartUI.SHOPPING_CART_EMPTY_MESSAGE);
		return message.contains(value);
	}
}
