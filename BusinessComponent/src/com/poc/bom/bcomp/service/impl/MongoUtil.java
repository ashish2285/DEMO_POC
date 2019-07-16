package com.poc.bom.bcomp.service.impl;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.poc.bcomp.dto.PriceServiceData;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MongoUtil {
	
	public static void main(String[] args) {
		createData();
	}
	
	public static HashMap<String,String> createData() {
		
		HashMap<String,String> myMap = new HashMap<String,String>();
		try {
			MongoClient mongo = new MongoClient("localhost",27017);
			 
			  MongoCredential credential; 
		      credential = MongoCredential.createCredential("user", "myDb", 
		         "password".toCharArray()); 
		      System.out.println("Connected to the database successfully");  
		      
		   // Accessing the database 
		      MongoDatabase database = mongo.getDatabase("myDb"); 
			  MongoCollection<Document> pricingData = database.getCollection("PRICING_DATA");
			 
			 PriceServiceData priceServiceData = new PriceServiceData();
			 
			 Document nacaDocument = new Document("type","NACA")
		               .append("rate","5")
		               .append("term","15")
		               .append("productCode","NACA1")
		               .append("Channel","NACA_channel");
			 
			 Document fhaDocument = new Document("type","FHA")
		               .append("rate","8")
		               .append("term","20")
		               .append("productCode","FHA1")
		               .append("Channel","FHA_channel");
			 
			 Document convDocument = new Document("type","CONV")
		               .append("rate","4")
		               .append("term","10")
		               .append("productCode","CONV1")
		               .append("Channel","CONV_channel");
			 
			 pricingData.insertOne(nacaDocument);
			 pricingData.insertOne(convDocument);
			 pricingData.insertOne(fhaDocument);
			 
			 MongoCursor<Document> cursor  =  pricingData.find(eq("type", "NACA")).iterator();
			 
				    while (cursor.hasNext()) {
				    	Document response = cursor.next();
				    	//Object test = cursor.next().toJson();
				    	Set<Entry<String, Object>> myset = response.entrySet();
				    	Iterator itr  = myset.iterator();
				    	while(itr.hasNext()) {
				    		Entry entry = (Entry) itr.next();
				    		String key = (String) entry.getKey();
				    		if(!key.equals("_id")) {
				    		String value = (String) entry.getValue();
				    		System.out.println(key);
				    		System.out.println(value);
				    		myMap.put(key, value);
				    		}
				    		
				    	}
				        //System.out.println(cursor.next().toJson());
				    }


			 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return myMap;
	}
}
