package pageUIsdataTable;

public class HomePageUI {
	public static final String PAGING_BY_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGING_BY_NUMBER_ACTIVED = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_NAME 
		= "//div[@class='qgrd-header-text' and text()='%s' ]/parent::div/following-sibling::input[@class='qgrd-header-filter']";
	public static final String ROW 
		= "//td[@data-key='females' and text()= '%s']//following-sibling::td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='males' and text()='%s' ]//following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ICON_BY_COUNTRY_NAME 
		= "//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[@class='qgrd-%s-row-btn']";
}
