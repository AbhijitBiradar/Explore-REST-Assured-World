package com.restassuredapi.utils;

import io.restassured.path.json.JsonPath;

public class JsonUtil {
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}
}
