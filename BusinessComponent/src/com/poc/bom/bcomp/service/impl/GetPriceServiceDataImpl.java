package com.poc.bom.bcomp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.poc.bcomp.dto.PriceQuotes;
import com.poc.bcomp.dto.PriceServiceData;

public class GetPriceServiceDataImpl {
	
	
	public String getPriceData(String type) {
		
		PriceQuotes priceQuotes = new PriceQuotes();
		List<PriceServiceData> priceServiceDataList = new ArrayList<PriceServiceData>();
		
		XMLHelper xmlHelper = new XMLHelper();
		
		HashMap responseMap = MongoUtil.createData();
		
		System.out.println(responseMap.size());
		
		if(null!=type && type.equalsIgnoreCase("ALL")) {
			
			PriceServiceData priceServiceData = new PriceServiceData();
			
			priceServiceData.setChannel("Conv Channel One");
			priceServiceData.setEntity("Retail");
			priceServiceData.setProductCode("Conv1");
			priceServiceData.setRate(5);
			priceServiceData.setTerm(15);
			priceServiceData.setType("Conventional");
			
			PriceServiceData priceServiceData1 = new PriceServiceData();
			priceServiceData1.setChannel("FHA Channel One");
			priceServiceData1.setEntity("Retail");
			priceServiceData1.setProductCode("FHA1");
			priceServiceData1.setRate(5);
			priceServiceData1.setTerm(15);
			priceServiceData1.setType("FHA");
			
			PriceServiceData priceServiceData2= new PriceServiceData();
			
			priceServiceData2.setChannel("NACA Channel One");
			priceServiceData2.setEntity("Retail");
			priceServiceData2.setProductCode("NACA1");
			priceServiceData2.setRate(5);
			priceServiceData2.setTerm(20);
			priceServiceData2.setType("NACA");
			
			priceServiceDataList.add(priceServiceData);
			priceServiceDataList.add(priceServiceData1);
			priceServiceDataList.add(priceServiceData2);
		}
		// hard coded values will get these values form rule
		if(null!=type && type.equalsIgnoreCase("NACA")) {
			
			PriceServiceData priceServiceData = new PriceServiceData();
			
			priceServiceData.setChannel("NACA Channel One");
			priceServiceData.setEntity("Retail");
			priceServiceData.setProductCode("NACA1");
			priceServiceData.setRate(5);
			priceServiceData.setTerm(20);
			priceServiceData.setType("NACA");
			
			priceServiceDataList.add(priceServiceData);
		}
		if(null!=type && type.equalsIgnoreCase("FHA")) {
			
			PriceServiceData priceServiceData = new PriceServiceData();
			priceServiceData.setChannel("FHA Channel One");
			priceServiceData.setEntity("Retail");
			priceServiceData.setProductCode("FHA1");
			priceServiceData.setRate(5);
			priceServiceData.setTerm(15);
			priceServiceData.setType("FHA");
			
			priceServiceDataList.add(priceServiceData);
		}
		if(null!=type && type.equalsIgnoreCase("Conventional")) {
			
			PriceServiceData priceServiceData = new PriceServiceData();
			
			priceServiceData.setChannel("Conv Channel One");
			priceServiceData.setEntity("Retail");
			priceServiceData.setProductCode("Conv1");
			priceServiceData.setRate(5);
			priceServiceData.setTerm(15);
			priceServiceData.setType("Conventional");
			
			priceServiceDataList.add(priceServiceData);
		}
		
		priceQuotes.setPriceServiceList(priceServiceDataList);	
		String priceXML = xmlHelper.getPriceXml(priceQuotes);
		System.out.println("PRICE XML ::::: " + priceXML);
		return priceXML;
	}
	
	

}
