package com.restassuredapi.managers;

import org.testng.annotations.DataProvider;

public class TestDataManager {
	@DataProvider(name="AddBookTestData")
	public Object[][] getTestData() {
		return new Object[][] {
				{
					"aaaa","bbbb"
				}
		};
	}
}
