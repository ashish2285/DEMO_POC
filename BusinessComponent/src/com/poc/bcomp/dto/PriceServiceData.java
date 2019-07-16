package com.poc.bcomp.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "" , propOrder  = {
		
		"rate",
		"term",
		"channel",
		"entity",
		"productCode",
		"type"
		
})
@XmlRootElement(name = "PriceServiceData")
public class PriceServiceData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="rate")
	protected Integer rate;
	@XmlElement(name="term")
	protected Integer term;
	@XmlElement(name="channel")
	protected String channel;
	@XmlElement(name="entity")
	protected String entity;
	@XmlElement(name="productCode")
	protected String productCode;
	@XmlElement(name="type")
	protected String type;
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
