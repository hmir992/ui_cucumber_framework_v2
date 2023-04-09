package com.cucumberFramework.helper;

public class Constants {

//	set which browser to run on
//	options include : 
//	CHROME for Chrome browser
//	FIREFOX for firefox browser

	public final static String browser = "Chrome";

	public final static String userNameTest = "1234automation567@gmail.com";
	public final static String passwordTest = "Consultant1234@";
	
	public final static String userName = "test1234qq@gmail.com";
	public final static String password = "111111";
	
	public final static String userNameIncorrect = "qq@gmail.com";
	public final static String passwordIncorrect = "qq";
	
	public final static String searchItem = "book";
	
	public final static String searchItemResult = "Health Book";
	

	public final static String phoneNumber = "083482922312";
	public final static String cardHolderName = "Automation";

	public final static String addressLine = "test";
	public final static String city = "dublin";

	public final static String country = "ireland";
	public final static String zipcode = "0000";

	public final static String errorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
			+ "The credentials provided are incorrect";
	public final static String loginMessage = "test1234qq@gmail.com";

	public final static long explicitWait = 100;
	public final static long impliciteWait = 100;

	public final static String adultFirstNameOne = "John";
	public final static String adultSurNameOne = "Barry";

	public final static String adultFirstNameTwo = "Automation";
	public final static String adultSurNameTwo = "Test";

	public final static String childFirstNameOne = "Harry";
	public final static String childSurNameOne = "Potter";

	public static String getBrowser() {
		return browser;
	}

	public static String getUsername() {
		return userName;
	}
	
	public static String getSearchitem() {
		return searchItem;
	}
	
	public static String getSearchItemResult() {
		return searchItemResult;
	}

	public static String getPassword() {
		return password;
	}
	
	public static String getIncorrectUsername() {
		return userNameIncorrect;
	}

	public static String getIncorrectPassword() {
		return passwordIncorrect;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static String getloginMessage() {
		return loginMessage;
	}

	public static String getPhoneNumber() {
		return phoneNumber;
	}

	public static String getCardHolderName() {
		return cardHolderName;
	}

	public static String getCity() {
		return city;
	}

	public static String getCountry() {
		return country;
	}

	public static String getAddressLine() {
		return addressLine;
	}

	public static String getZipCode() {
		return zipcode;
	}

	public static String getAdultFirstNameOne() {
		return adultFirstNameOne;
	}

	public static String getAdultSurNameOne() {
		return adultSurNameOne;
	}

	public static String getAdultFirstNameTwo() {
		return adultFirstNameTwo;
	}

	public static String getAdultSurNameTwo() {
		return adultSurNameTwo;
	}

	public static String getChildFirstNameOne() {
		return childFirstNameOne;
	}

	public static String getChildSurNameOne() {
		return childSurNameOne;
	}

	public static long getExplicitwait() {
		return explicitWait;
	}

	public static long getImplicitewait() {
		return impliciteWait;
	}

}
