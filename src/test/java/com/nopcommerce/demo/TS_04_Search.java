package com.nopcommerce.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.SearchPageObject;
import pageUls.SearchPageUI;

public class TS_04_Search {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	SearchPageObject searchPage;
	String url = "https://demo.nopcommerce.com/search";

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		driver = new FirefoxDriver();
		searchPage = new SearchPageObject(driver);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_SearchWithEmtyData() {
		searchPage.inputToSearchKeywordTextbox("");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isMiniumLengthCharacters("Search term minimum length is 3 characters"));
	}

	@Test
	public void TC_02_SearchWithDataExist() {
		searchPage.inputToSearchKeywordTextbox("Macbook Pro 2040");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isMiniumLengthCharacters("No products were found that matched your criteria."));
	}

	@Test
	public void TC_03_SearchWithLenovoKeyword() {
		searchPage.inputToSearchKeywordTextbox("Lenovo");
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isVerifyElementsOfKeys("Lenovo"));

	}

	@Test
	public void TC_04_AdvanceSearchWithParentCategories() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPage.tickToAdvancedSearchCheckbox();
		searchPage.chooseTextOfDropdown("Computers");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isNotProduct("No products were found that matched your criteria."));
	}

	@Test
	public void TC_05_WithAdvanceSearchSubCategories() {
		searchPage.inputToSearchKeywordTextbox("Apple Macbook Pro");
		if (searchPage.isAdvancedSearchChecked() == true) {
			searchPage.chooseTextOfDropdown("Computers");
			searchPage.tickToAutomaticallySearchSubCategories();
			searchPage.clickToSearchButton();

			Assert.assertTrue(searchPage.isVerifyElementsOfKeys("Apple MacBook"));

		} else {
			searchPage.tickToAdvancedSearchCheckbox();
			searchPage.chooseTextOfDropdown("Computers");
			searchPage.tickToAutomaticallySearchSubCategories();
			searchPage.clickToSearchButton();

			Assert.assertTrue(searchPage.isVerifyElementsOfKeys("Apple MacBook"));
		}
	}
}
