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
import reportConfigV5.ExtentTestManager;

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
		ExtentTestManager.startTest("Search with emty data", "");
		searchPage.inputToSearchKeywordTextbox("");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isMiniumLengthCharacters
				("Search term minimum length is 3 characters"));
	}

	@Test
	public void TC_02_SearchWithDataExist() {
		ExtentTestManager.startTest("Search With Data Exist", "");
		searchPage.inputToSearchKeywordTextbox("Macbook Pro 2040");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isMiniumLengthCharacters
				("No products were found that matched your criteria."));
	}

	@Test
	public void TC_03_SearchWithLenovoKeyword() {
		ExtentTestManager.startTest("Search With Lenovo Keyword", "");
		searchPage.inputToSearchKeywordTextbox("Lenovo");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isVerifyKeysOfElements("Lenovo"));

	}

	@Test
	public void TC_04_AdvanceSearchWithParentCategories() {
		ExtentTestManager.startTest("Advance Search With Parent Categories", "");
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
		ExtentTestManager.startTest("With Advance Search SubCategories", "");
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
