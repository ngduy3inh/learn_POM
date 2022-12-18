package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.LoginPageObejct;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;
import reportConfigV5.ExtentTestManager;

public class TS_06_ShoppingCart extends BaseTest{
	WebDriver driver;
	LoginPageObejct loginPage;
	WishListPageObject wishList;
	ShoppingCartPageObject shoppingCart;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String nameBrowser) {
		String urlLogin = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(nameBrowser, urlLogin);
		
		wishList = new WishListPageObject(driver);
		shoppingCart = new ShoppingCartPageObject(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void TC_01_UpdateShoppingCart() {
		ExtentTestManager.startTest("Update Shopping Cart", "");
		wishList.loginWithAccount(GlobalContants.email, GlobalContants.password);
		
		wishList.clickToLabelOfMenu("cart");
		shoppingCart.inputQuantityForProduct("HTC One M8 Android L 5.0 Lollipop","5");
		shoppingCart.inputQuantityForProduct("Apple MacBook Pro 13-inch","5");
		shoppingCart.clickToUpdateShoppingCartButton();
		
		Assert.assertTrue(shoppingCart.isUpdatedQuantityMacbook("5"));
	}

	@Test
	void TC_02_RemoveFromCart() {
		ExtentTestManager.startTest("Remove From Cart", "");
		wishList.clickToLabelOfMenu("cart");
		shoppingCart.clickToRemoveProductInShoppingCart("HTC One M8 Android L 5.0 Lollipop");
		shoppingCart.clickToRemoveProductInShoppingCart("Apple MacBook Pro 13-inch");
		Assert.assertTrue(shoppingCart.isShoppingCartEmpty("Your Shopping Cart is empty!"));
	}
}
