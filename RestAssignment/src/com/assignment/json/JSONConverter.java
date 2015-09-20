package com.assignment.json;

import com.assignment.model.Product;
import com.google.gson.Gson;

public class JSONConverter {
	public static void main(String[] args) {

//		Merchant obj = new Merchant();
//		obj.setCountry("India");
//		obj.setCurrency("Rupee");
//		obj.setName("Satvik");
		
		Product prod = new Product();
		prod.setPname("Mer1Product");
		prod.setPrice(1.0);
		prod.setMerchantId("0");
		Gson gson = new Gson();

		// convert java object to JSON format,
		// and returned as JSON formatted string
		String json = gson.toJson(prod);

		System.out.println(json);

		//System.out.println(json);

	    }
	
}
