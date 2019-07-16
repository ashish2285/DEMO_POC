package com.poc.bcomp.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adaptor3 extends XmlAdapter<String, String> {

	@Override
	public String marshal(String value) throws Exception {
		return (StringAdaptor.parseString(value));
	}

	@Override
	public String unmarshal(String value) throws Exception {
		return (StringAdaptor.parseString(value));
	}

}
