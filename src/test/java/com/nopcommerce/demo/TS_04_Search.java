package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.SearchPageObject;

public class TS_04_Search extends BaseTest {
	WebDriver driver;
	SearchPageObject searchPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String nameBrowser) {
		String url = "https://demo.nopcommerce.com/search";
		driver = getBrowserDriver(nameBrowser, url);
		
		searchPage = new SearchPageObject(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_SearchWithEmtyData() {
		searchPage.inputToSearchKeywordTextbox("");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isMiniumLengthCharacters
				("Search term minimum length is 3 characters"));
	}

	@Test
	public void TC_02_SearchWithDataExist() {
		searchPage.inputToSearchKeywordTextbox("Macbook Pro 2040");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isMiniumLengthCharacters
				("No products were found that matched your criteria."));
	}

	@Test
	public void TC_03_SearchWithLenovoKeyword() {
		searchPage.inputToSearchKeywordTextbox("Lenovo");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isVerifyKeysOfElements("Lenovo"));

	}

	@Test
	public void TC_04_AdvanceSearchWithParentCategories() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.tickToSearchCheckbox("advs");
		searchPage.enterTextToCategoryDropdown("Computers");
		if(searchPage.isCheckboxChecked("isc") == false) {
			System.out.println(searchPage.isCheckboxChecked("isc") + " is unchecked");
		}else {
			searchPage.tickToSearchCheckbox("isc");
		}
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isNotProduct
				("No products were found that matched your criteria."));
	}

	@Test
	public void TC_05_WithAdvanceSearchSubCategories() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		if (searchPage.isCheckboxChecked("advs") == true) {
			System.out.println(searchPage.isCheckboxChecked("advs") + " is checked");
		} else {
			searchPage.tickToSearchCheckbox("advs");
		}
		searchPage.enterTextToCategoryDropdown("Computers");
		searchPage.isCheckboxChecked("isc");//
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isVerifyKeysOfElements("Apple MacBook"));//
	}
}
