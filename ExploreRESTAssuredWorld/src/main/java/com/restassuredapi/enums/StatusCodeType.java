package com.restassuredapi.enums;

public enum StatusCodeType {
	OK(200),
	NOT_FOUND(404);	
	
	private int value; 
	
	private StatusCodeType(int value) { 
		this.value = value; 
	}	
	
	public int getValue() {
        return value;
    }
}
