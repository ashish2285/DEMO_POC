package com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {
	
	@Autowired
	public GetPriceDataService getPriceDataService;
	
	@RequestMapping(value = "/getPricedata")
	public String fetchPriceService(@RequestParam(value="type",defaultValue = "ALL")String type) {
		return getPriceDataService.getPriceDataServiceForProduct(type);
		
	}
	

}
