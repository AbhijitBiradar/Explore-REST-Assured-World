package com.restassuredapi.paylods;

public class BookPayloads {
	public static String addBook(String aisle, String isbn) {		
		return "{\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"" + isbn + "\",\r\n" + 
				"\"aisle\":\"" + aisle +"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
	}
}
