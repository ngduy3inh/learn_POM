package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUls.WishListUI;

public class WishListPageObject extends BasePage {
	WebDriver driver;

	public WishListPageObject(WebDriver driver) {
		//super(driver);
		this.driver = driver;
	}

	public void chooseToMacbook() {
		clickToElement(driver, WishListUI.APPLE_MACBOOK_PRO_13_INCH_TEXT);
	}
	public void chooseProduct(String nameProduct) {
		waitForElementVisible(driver, WishListUI.NAME_PRODUCT, nameProduct);
		clickToElement(driver, WishListUI.NAME_PRODUCT, nameProduct);
	}

	public void clickToAddToWishList(String idButton) {
		clickToElement(driver, WishListUI.ADD_TO_WISHLIST_BUTTON, idButton);
	}

	public boolean isAddedToShoppingCart(String value) {
		waitForElementVisible(driver, WishListUI.NOTIFICATION_MESSAGE);
		String message = getTextOfElement(driver, WishListUI.NOTIFICATION_MESSAGE);
		return message.contains(value);
	}
//	public void clickToCloseNotifiCationAdded() {
//		clickToElement(driver, WishListUI.CLOSE_NOTIFICATION_MESSAGE);
//	}
	public void clickToCloseNotifiCationAdded() {
		clickToElement(driver, WishListUI.CLOSE_NOTIFICATION_MESSAGE);
		waitForElementInvisible(driver, WishListUI.CLOSE_NOTIFICATION_MESSAGE);
	}
	
	public void clickToWishListLabel() {
		clickToElement(driver, WishListUI.WISTHLIST_LABEL);
	}
	
	public boolean isNameProductAddedToWishlist(String nameProduct) {
		String message = getTextOfElement(driver, WishListUI.NAME_PRODUCT_IN_WISHLIST, nameProduct);
		return message.contains(nameProduct);
	}
	
	public void clickToWishListAddToCartButton() {
		clickToElement(driver, WishListUI.WISHLIST_ADD_TO_CART_BUTTON);
	}
	
	public void tickToProductCheckbox(String nameProduct) {
		clickToElement(driver, WishListUI.PRODUCTS_IN_WISHLIST_CHECKBOX, nameProduct);
	}
	
	public void clickToShoppingCartLabel() {
		clickToElement(driver, WishListUI.SHOPPING_CART_LABEL);
	}
	
	public boolean isRemovedFromWishList(String name) {
		String message = getTextOfElement(driver, WishListUI.PRODUCT_NAME_TEXT);
		return message.contains(name);
	}
	
	public boolean isNoData(String value) {
		String message = getTextOfElement(driver, WishListUI.NO_DATA_TEXT);
		return message.contains(value);
	}
	
//	public void hoverToElementOfTopMenu() {
//		hoverToElement(driver, HeaderPageUI.TOP_MENU_ELECTRO);
//	}
}
