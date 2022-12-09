package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

}
