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
	
	public boolean isNameProductAdded(String nameProduct) {
		String message = getTextOfElement(driver, WishListUI.NAME_PRODUCT_IN_SHOPPING_CART, nameProduct);
		return message.contains(nameProduct);
	}
	
	public void clickToShoppingCartLabel() {
		clickToElement(driver, ShoppingCartUI.SHOPPING_CART_LABEL);
	}
	
	public void inputQuantityForProduct(String nameProductText, String valueInput) {
		sendKeysToElement(driver, ShoppingCartUI.QUANTITY_OF_PRODUCT_TEXTBOX, valueInput, nameProductText);
	}
	
	public void clickToUpdateShoppingCartButton() {
		clickToElement(driver, ShoppingCartUI.UPDATE_SHOPPING_CART_BUTTON);
	}
	
	public boolean isUpdatedQuantityMacbook(String value) {
		String message = getAttributeValue(driver, ShoppingCartUI.QUANTITY_MACBOOK_TEXTBOX, "value");
		return message.contains(value);
	}
	
	public void clickToRemoveProductInShoppingCart(String nameProduct) {
		clickToElement(driver, ShoppingCartUI.REMOVE_PRODUCT_IN_SHOPPING_CART_BUTTON, nameProduct);
	}
	
	public boolean isShoppingCartEmpty(String value) {
		String message = getTextOfElement(driver, ShoppingCartUI.SHOPPING_CART_EMPTY_MESSAGE);
		return message.contains(value);
	}
}
