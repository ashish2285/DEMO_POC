package com.poc;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.poc.bcomp.dto.PriceQuotes;
import com.poc.bcomp.dto.PriceServiceData;

public class XMLHelper {

	private PriceServiceDataDto priceServiceDataDto;

	// private PriceQuotes priceQuotes;

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		XMLHelper xmlHelper = new XMLHelper();
	}

	
	public static PriceQuotesDto getPriceServiceObject(String priceServiceDataXml) {

		PriceServiceData priceServiceData = null;
		PriceQuotesDto priceQuotesDto = new PriceQuotesDto();
		List<PriceServiceDataDto> priceServiceDataDtoList = new ArrayList<PriceServiceDataDto>();
		PriceQuotes priceQuotes = null;
		JAXBContext jaxbContext;
		
		  try {
		  
		  jaxbContext = JAXBContext.newInstance(PriceQuotes.class); 
		  Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); 
		  InputStream is = new ByteArrayInputStream(priceServiceDataXml.getBytes()); 
		  StreamSource ss = new StreamSource(is);
		  JAXBElement<PriceQuotes> element =  unmarshaller.unmarshal(ss, PriceQuotes.class); 
		  priceQuotes = element.getValue();
		  
		  List<PriceServiceData> priceServicedataList = priceQuotes.getPriceServiceList();
		  
		  for (PriceServiceData priceServiceData2 : priceServicedataList) {
			
			  PriceServiceDataDto priceServiceDataDto = new PriceServiceDataDto();
			  priceServiceDataDto.setChannel(priceServiceData2.getChannel());
			  priceServiceDataDto.setEntity(priceServiceData2.getEntity());
			  priceServiceDataDto.setProductCode(priceServiceData2.getProductCode());
			  priceServiceDataDto.setRate(priceServiceData2.getRate());
			  priceServiceDataDto.setTerm(priceServiceData2.getTerm());
			  priceServiceDataDto.setType(priceServiceData2.getType());
			  priceServiceDataDtoList.add(priceServiceDataDto);
		}
		  priceQuotesDto.setPriceServiceList(priceServiceDataDtoList);
		  
		  } catch (JAXBException e) { e.printStackTrace(); }
		  
		  return priceQuotesDto;
		 
	}
}
