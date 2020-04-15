package com.restassuredapi.basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.restassuredapi.configs.Config;
import com.restassuredapi.paylods.PlacePayload;
import com.restassuredapi.resources.PlaceResource;
import com.restassuredapi.utils.JsonUtil;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;


public class Basics {	
	
	public static void main(String[] args) {
		
		String newAddress = "Summer Walk, Africa";
		
		String placeId=addPlace();
		updatePlace(placeId, newAddress);
		getUpdatedPlace(placeId, newAddress);
	}
	
	public static String addPlace() {
		RestAssured.baseURI=Config.BASE_URI;
		String response=given()
							.log().all()
							.queryParam("key", "qaclick123")
							.header("Content-Type","application/json")
							.body(PlacePayload.addPlace())
						.when()
							.post(PlaceResource.addPlaceResource())
						.then()
							.log().all()
							.assertThat().statusCode(200)
										 .body("scope", equalTo("APP"))	
										 .header("server", "Apache/2.4.18 (Ubuntu)")
							.extract().response().asString();
		
		JsonPath jsonPath=JsonUtil.rawToJson(response);
		String placeId=jsonPath.getString("place_id");
		
		System.out.println("Place ID: " + placeId);
		
		return placeId;
	}
	
	public static void updatePlace(String placeId, String newAddress) {		
		given()
			.log().all()
			.queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body(PlacePayload.updatePlace(placeId, newAddress))
		.when()
			.put(PlaceResource.updatePlaceResource())
		.then()
			.assertThat()
				.log().all()
				.statusCode(200)
				.body("msg", equalTo("Address successfully updated"));
	}
	
	public static void getUpdatedPlace(String placeId, String expectedAddress) {
		String response=given()
							.log().all()
							.queryParam("key", "qaclick123").queryParam("place_id",placeId)
						.when()
							.get("maps/api/place/get/json")
						.then()
							.log().all()
							.assertThat()
								.statusCode(200)
							.extract().response().asString();
		
		JsonPath jsonPath=JsonUtil.rawToJson(response);
		String actualAddress =jsonPath.getString("address");
		
		Assert.assertEquals(actualAddress, expectedAddress);	
		
	}
}










