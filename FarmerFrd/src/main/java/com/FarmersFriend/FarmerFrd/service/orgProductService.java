package com.FarmersFriend.FarmerFrd.service;

import java.util.List;

import com.FarmersFriend.FarmerFrd.entities.orgProduct;


public interface orgProductService {
		
	List<orgProduct> getAllProducts();
	
	public orgProduct getProductById(int pId);
}
