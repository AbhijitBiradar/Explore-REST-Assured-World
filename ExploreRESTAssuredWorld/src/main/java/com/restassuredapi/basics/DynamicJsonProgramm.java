package com.restassuredapi.basics;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import com.restassuredapi.configs.Config;
import com.restassuredapi.enums.StatusCodeType;
import com.restassuredapi.managers.TestDataManager;
import com.restassuredapi.paylods.BookPayloads;
import com.restassuredapi.paylods.BookResource;
import com.restassuredapi.utils.JsonUtil;
import com.restasuredapi.constants.HeaderConstants;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJsonProgramm {
		
	@Test(dataProvider="AddBookTestData", dataProviderClass=TestDataManager.class)
	public void addBook(String aisle, String isbn) throws IOException {
		RestAssured.baseURI=Config.BASE_URI1;

		String  response=given()
						.header(HeaderConstants.CONTENT_TYPE,HeaderConstants.APPLICATION_JSON)											
						.body(BookPayloads.addBook(aisle,isbn))
					  .when()
					  	.post(BookResource.addBookReource())
					  .then()
					  	.assertThat().statusCode(StatusCodeType.OK.getValue())
					  	.extract().response().asString();

		JsonPath js= JsonUtil.rawToJson(response);

		String id=js.get("ID");

		System.out.println("ID : "+ id);
	}		
}
