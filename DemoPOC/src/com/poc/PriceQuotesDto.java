package com.poc;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "PriceQuotes")
public class PriceQuotesDto {
	
	List<PriceServiceDataDto> priceServiceList;

	public List<PriceServiceDataDto> getPriceServiceList() {
		return priceServiceList;
	}

	public void setPriceServiceList(List<PriceServiceDataDto> priceServiceList) {
		this.priceServiceList = priceServiceList;
	}
}
