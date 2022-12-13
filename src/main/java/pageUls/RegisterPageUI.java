package pageUls;

public class RegisterPageUI {
	
	public static final String MALE_RADIO_BUTTON = "//input[@id='gender-male']";
	public static final String FAMALE_RADIO_BUTTON = "//input[@id='gender-female']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String PASSSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String LOGOUT_BUTTON = "//a[@class='ico-logout']";

	// message
//	public static final String FIRT_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
//	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
//	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
//	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
//	public static final String PASSWORD_NOT_MATCH_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
//	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	
	public static final String REQUIRED_ERROR_MESSAGE = "//span[@id='%s-error']";
	
	public static final String EMAIL_ALREADY_EXIST_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors']";
	public static final String REGISTER_COMPLETE_TEXT_MESSAGE = "//div[@class='result']";
}
