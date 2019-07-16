package com.poc.bom.bcomp.service.impl;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.poc.bcomp.dto.PriceQuotes;
import com.poc.bcomp.dto.PriceServiceData;

public class XMLHelper {

	
	public String getPriceXml(PriceQuotes priceQuotes) {

		String result = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(com.poc.bcomp.dto.PriceQuotes.class);
			StringWriter stringWriter = new StringWriter();
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(priceQuotes, stringWriter);
			result = stringWriter.toString();
		} catch (JAXBException exception) {
			System.out.println(exception.getMessage());
		}
		return result;

	}
}
