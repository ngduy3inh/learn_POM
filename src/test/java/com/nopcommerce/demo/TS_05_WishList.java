package com.nopcommerce.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.LoginPageObejct;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;
import pageUls.WishListUI;

public class TS_05_WishList {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String urlLogin = "https://demo.nopcommerce.com/login?returnUrl=%2F";
	LoginPageObejct loginPage;
	WishListPageObject wishList;
	ShoppingCartPageObject shoppingCart;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new FirefoxDriver();
		loginPage = new LoginPageObejct(driver);
		wishList = new WishListPageObject(driver);
		shoppingCart = new ShoppingCartPageObject(driver);
		driver.get(urlLogin);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_AddToWishList() {
		loginPage.loginWithAccount(GlobalContants.email, GlobalContants.password);
		wishList.chooseToMacbook();
		wishList.clickToAddToWishList();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(wishList.findElement(driver, WishListUI.NOTIFICATION_MESSAGE).getText());
		Assert.assertTrue(wishList.isAddedToShoppingCart("The product has been added to your wishlist"));
		wishList.clickToCloseNotifiCationAdded();
		wishList.clickToWishListLabel();
		wishList.isNameProductAdded("Apple MacBook Pro 13-inch");
	}

	@Test      
	public void TC_02_AddProductFromWishList() {
		wishList.clickToWishListLabel();
		wishList.tickToProductCheckbox();
		wishList.clickToWishListAddToCartButton();
		Assert.assertTrue(shoppingCart.isNameProductAdded("Apple MacBook Pro 13-inch"));
		wishList.clickToWishListLabel();
		Assert.assertTrue(wishList.isNoData("The wishlist is empty!"));
	}

}
