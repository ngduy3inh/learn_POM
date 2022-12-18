package DataTable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjectsdataTable.HomePageObject;

public class DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsweName) {
		String url = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
		driver = getBrowserDriver(browsweName, url);
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	//@Test
	public void TC_01_Paging() {
		homePage.openPageNumber("5");
		BaseTest.sleepInSeconds(2);
		Assert.assertTrue(homePage.isPageActivedPageNumber("5"));
		homePage.openPageNumber("15");
		BaseTest.sleepInSeconds(2);
		Assert.assertTrue(homePage.isPageActivedPageNumber("15"));
		
		homePage.refeshCurrentPage(driver);
		
	}
	
	@Test
	public void TC_02_SearchAndVerify() {
		homePage.refeshCurrentPage(driver);
		homePage.inputToHeaderTextboxByName("Country", "AFRICA");
		Assert.assertTrue(homePage.isRowValueDisplay("12253515", "AFRICA", "12599691", "24853148"));
		sleepInSeconds(3);
		homePage.refeshCurrentPage(driver);
		homePage.clickByIconCountryName("AFRICA", "remove");
		homePage.inputToHeaderTextboxByName("Country", "AFRICA");
		Assert.assertTrue(homePage.isDataRemoved("12253515", "AFRICA", "12599691", "24853148"));;
	}
}
