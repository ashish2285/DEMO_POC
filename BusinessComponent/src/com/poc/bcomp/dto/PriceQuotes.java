package com.poc.bcomp.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PriceQuotes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceQuotes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "PriceServiceData")
	List<PriceServiceData> priceServiceList = null;
	
	public PriceQuotes() {
		super();
	}
	
	public PriceQuotes(List<PriceServiceData> priceServiceList) {
		this.priceServiceList = priceServiceList;
	}

	public List<PriceServiceData> getPriceServiceList() {
		return priceServiceList;
	}

	
	public void setPriceServiceList(List<PriceServiceData> priceServiceList) {
		this.priceServiceList = priceServiceList;
	}

}
