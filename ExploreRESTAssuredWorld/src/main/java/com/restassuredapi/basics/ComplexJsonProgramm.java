package com.restassuredapi.basics;

import com.restassuredapi.mocks.PlaceMocks;

import io.restassured.path.json.JsonPath;

public class ComplexJsonProgramm {

	public static void main(String[] args) {
		JsonPath js=new JsonPath(PlaceMocks.coursePrice());
		
		//Print Course Count
		int count=	js.getInt("courses.size()");
		System.out.println("Total No. of Courses: " + count);
		
		//Print Purchase Amount
		int totalAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println("Course Purchase Amount: "+ totalAmount);
		
		//Print Title of the first course
		String titleFirstCourse=js.get("courses[2].title");
		System.out.println("Title of the first course: "+ titleFirstCourse);
	}
}
