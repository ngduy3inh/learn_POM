package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.GlobalContants;
import pageObjects.LoginPageObejct;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;
import pageUls.ShoppingCartUI;

public class TS_06_ShoppingCart {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String urlLogin = "https://demo.nopcommerce.com/login?returnUrl=%2F";
	LoginPageObejct loginPage;
	WishListPageObject wishList;
	ShoppingCartPageObject shoppingCart;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new FirefoxDriver();
		loginPage = new LoginPageObejct(driver);
		wishList = new WishListPageObject(driver);
		shoppingCart = new ShoppingCartPageObject(driver);
		driver.get(urlLogin);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void TC_01_UpdateShoppingCart() {
		loginPage.loginWithAccount(GlobalContants.email, GlobalContants.password);
		shoppingCart.clickToShoppingCartLabel();
		shoppingCart.inputQuantity("5");
		shoppingCart.clickToUpdateShoppingCartButton();
		shoppingCart.isUpdatedQuantityMacbook("5");
	}

	@Test
	void TC_02_RemoveFromCart() {
		shoppingCart.clickToShoppingCartLabel();
		shoppingCart.clickToRemoveProductMacbook();
		shoppingCart.isShoppingCartEmpty("Your Shopping Cart is empty! ");
	}
}