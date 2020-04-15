package com.restassuredapi.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonUtil {	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}
}
