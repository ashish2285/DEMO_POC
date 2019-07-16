package com.poc.bcomp.util;

public class StringAdaptor {

	private final static String EMPTY_STRING = "";
	
	public static String parseString(String value) {
		return (value == null || value.trim().length() == 0) ? EMPTY_STRING : value;
	}
	
	public static String printString(String value) {
		return (value == null || value.trim().length() == 0) ? EMPTY_STRING : value;
	}
}
