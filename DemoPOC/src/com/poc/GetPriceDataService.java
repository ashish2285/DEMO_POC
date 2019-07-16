package com.poc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.bom.bcomp.service.impl.GetPriceServiceDataImpl;

@Service
public class GetPriceDataService {
	
	private StringBuffer priceStr = null;
	
	public String getPriceDataServiceForProduct(String type) {
		
		GetPriceServiceDataImpl getPriceServiceDataImpl = new GetPriceServiceDataImpl();
		
		String priceServiceDataXml = getPriceServiceDataImpl.getPriceData(type);
		
		PriceQuotesDto priceQuotesDto = XMLHelper.getPriceServiceObject(priceServiceDataXml);
		
		priceStr = new StringBuffer();
		
		for(PriceServiceDataDto priceServiceData : priceQuotesDto.getPriceServiceList()) {
			  
			  priceStr.append("Price Data For Product - ").append(type).append(System.lineSeparator());
			  priceStr.append("------------------------------------------------------------------------").append(System.lineSeparator());
			  priceStr.append("Product Code :    " + priceServiceData.getProductCode()).append(System.lineSeparator());
			  priceStr.append("Entiry       :    " + priceServiceData.getEntity()).append(System.lineSeparator());
			  priceStr.append("Channel      :    " + priceServiceData.getChannel()).append(System.lineSeparator());
			  priceStr.append("Rate         :    " + priceServiceData.getRate()).append(System.lineSeparator());
			  priceStr.append("Term         :    " + priceServiceData.getTerm()).append(System.lineSeparator());
			  priceStr.append("------------------------------------------------------------------------").append(System.lineSeparator());
		}
		
		return priceStr.toString();
		
	}
	

}
