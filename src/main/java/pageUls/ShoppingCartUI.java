package pageUls;

public class ShoppingCartUI {
	public static final String SHOPPING_CART_LABEL = "//span[@class='cart-label']";
	public static final String QUANTITY_MACBOOK_TEXTBOX 
		= "//a[text()='Apple MacBook Pro 13-inch']/parent::td[@class='product']//following-sibling::td[@class='quantity']//input[@class='qty-input']";
	public static final String UPDATE_SHOPPING_CART_BUTTON =  "//button[@id='updatecart']";
	public static final String REMOVE_MACBOOK_SHOPPING_CART_BUTTON 
		= "//a[text()='Apple MacBook Pro 13-inch']/parent::td[@class='product']//following-sibling::td[@class='remove-from-cart']//button[@class='remove-btn']";
	public static final String SHOPPING_CART_EMPTY_MESSAGE 
		= "//div[@class='order-summary-content']";

}
