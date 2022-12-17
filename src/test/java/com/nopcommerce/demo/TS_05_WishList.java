package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageObjects.LoginPageObejct;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;

public class TS_05_WishList extends BaseTest{
	WebDriver driver;
	
	//LoginPageObejct loginPage;
	WishListPageObject wishList;
	ShoppingCartPageObject shoppingCart;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String nameBrowser) {
		String urlLogin = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		driver = getBrowserDriver(nameBrowser, urlLogin);
		
		//loginPage = new LoginPageObejct(driver);
		wishList = new WishListPageObject(driver);
		shoppingCart = new ShoppingCartPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	@Test
	public void TC_01_AddToWishList() {
		wishList.loginWithAccount(GlobalContants.email, GlobalContants.password);
		wishList.chooseProduct("Apple MacBook Pro 13-inch");
		wishList.clickToAddToWishList("4");
		
		Assert.assertTrue(wishList.isAddedToShoppingCart
				("The product has been added to your wishlist"));
		
		wishList.clickToCloseNotifiCationAdded();
		driver.navigate().back();
		
		wishList.chooseProduct("HTC One M8 Android L 5.0 Lollipop");
		wishList.clickToAddToWishList("18");
		
		Assert.assertTrue(wishList.isAddedToShoppingCart
				("The product has been added to your wishlist"));
		
		wishList.clickToCloseNotifiCationAdded();
		wishList.clickToLabelOfMenu("wishlist");
		wishList.isNameProductAddedToWishlist("Apple MacBook Pro 13-inch");
		wishList.isNameProductAddedToWishlist("HTC One M8 Android L 5.0 Lollipop");
	}

	@Test      
	public void TC_02_AddProductFromWishList() {
		wishList.clickToLabelOfMenu("wishlist");
		
		wishList.tickToProductCheckbox("Apple MacBook Pro 13-inch");
		wishList.tickToProductCheckbox("HTC One M8 Android L 5.0 Lollipop");
		wishList.clickToWishListAddToCartButton();
		
		Assert.assertTrue(shoppingCart.isNameProductAdded("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(shoppingCart.isNameProductAdded("HTC One M8 Android L 5.0 Lollipop"));
		wishList.clickToLabelOfMenu("wishlist");
		Assert.assertTrue(wishList.isNoData("The wishlist is empty!"));
	}

}
