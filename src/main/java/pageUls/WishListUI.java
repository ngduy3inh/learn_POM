package pageUls;

public class WishListUI {
	//////
	public static final String APPLE_MACBOOK_PRO_13_INCH_TEXT
		= "//h2[@class='product-title']/a[text()='Apple MacBook Pro 13-inch']";
	public static final String HTC_ONE_TEXT= "//h2[@class='product-title']/a[text()='HTC One M8 Android L 5.0 Lollipop']";
	public static final String NAME_PRODUCT
		= "//h2[@class='product-title']/a[text()='%s']";
	///////
	public static final String ADD_TO_WISHLIST_BUTTON 
		= "//button[@id='add-to-wishlist-button-%s']";
	public static final String ADD_HTC_TO_WISHLIST_BUTTON 
		= "//button[@id='add-to-wishlist-button-18']";
	////
	public static final String NAME_PRODUCT_IN_WISHLIST = "//td[@class='product']//a[text()='%s']";
	////
	public static final String PRODUCTS_IN_WISHLIST_CHECKBOX	
	= "//a[text()='%s']//parent::td[@class='product']//preceding-sibling::td[@class='add-to-cart']//input[@type='checkbox']";
	//////
	public static final String NAME_PRODUCT_IN_SHOPPING_CART 
		= "//td[@class='product']//a[text()='%s']";
	/////
	public static final String NOTIFICATION_MESSAGE = "//div[@class='bar-notification success']";
	
	public static final String WISTHLIST_LABEL = "//span[@class='wishlist-label']";
	public static final String SHOPPING_CART_LABEL= "//span[@class='cart-label']";
	public static final String CLOSE_NOTIFICATION_MESSAGE= "//span[@class='close']";//
	
	public static final String WISHLIST_ADD_TO_CART_BUTTON 
		= "//button[@class='button-2 wishlist-add-to-cart-button']";
	
	public static final String PRODUCT_NAME_TEXT = "//a[@class='product-name']";
	public static final String NO_DATA_TEXT = "//div[@class='no-data']";
	
}
