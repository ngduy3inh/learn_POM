package utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataFakerUtil {
	public Locale locale = new Locale("en");
	public Faker fake = new Faker(locale);

	public static DataFakerUtil getData() {
		return new DataFakerUtil();
	}
	
	public String getFirstName() {
		return fake.address().firstName();
	}
	
	public String getLastName() {
		return fake.address().lastName();
	}
	
	public String getEmail() {
		return fake.internet().emailAddress();
	}
	
	public String getZipcode() {
		return fake.address().zipCode();
	}
}
