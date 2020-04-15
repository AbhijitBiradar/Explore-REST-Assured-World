package com.restassuredapi.basics;

import org.testng.Assert;

import com.restassuredapi.mocks.PlaceMocks;

import io.restassured.path.json.JsonPath;

public class ComplexJsonProgramm {

	public static void main(String[] args) {
		JsonPath js = new JsonPath(PlaceMocks.coursePrice());

		// Print Course Count
		int count = js.getInt("courses.size()");
		System.out.println("Total No. of Courses: " + count);

		// Print Purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Course Purchase Amount: " + totalAmount);

		// Print Title of the first course
		String titleFirstCourse = js.get("courses[2].title");
		System.out.println("Title of the first course: " + titleFirstCourse);

		// Print All course titles and their respective Prices
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			String coursePrice = js.get("courses[" + i + "].price").toString();

			System.out.println("Course Title: " + courseTitles);
			System.out.println("Course Price: " + coursePrice);
		}

		// Print no of copies sold by RPA Course
		int copies = 0;
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			if (courseTitles.equalsIgnoreCase("RPA")) {
				copies = js.get("courses[" + i + "].copies");
				break;
			}
		}
		System.out.println("No. of copies sold by RPA Course: " + copies);

		//Verify summation of all course price is equal to Total Purchase Amount
		int sum = 0;		
		count = js.getInt("courses.size()");
		for (int i = 0; i < count; i++) {
			int price = js.getInt("courses[" + i + "].price");
			copies = js.getInt("courses[" + i + "].copies");
			int amount = price * copies;
			sum = sum + amount;
		}
		System.out.println("Sum of all curse price in the web page:  " +sum);
		
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}
}
