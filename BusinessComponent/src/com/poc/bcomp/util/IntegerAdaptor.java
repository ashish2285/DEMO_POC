package com.poc.bcomp.util;

import javax.xml.bind.DatatypeConverter;

public class IntegerAdaptor {
	
	private final static Integer EMPTY_NUMBER = new Integer(0);
	
	public static Integer parseInteger(String value) {
		return (value == null || value.trim().length() == 0) ? EMPTY_NUMBER : DatatypeConverter.parseInt(value);
	}
	
	public static Integer printInteger(String value) {
		return DatatypeConverter.parseInt(value);
	}

}
