package com.FarmersFriend.FarmerFrd.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.FarmersFriend.FarmerFrd.entities.orgProduct;

import com.FarmersFriend.FarmerFrd.exception.ProductNotFoundException;
import com.FarmersFriend.FarmerFrd.repository.FarmerRepository;
import com.FarmersFriend.FarmerFrd.repository.orgProductRepository;
import com.FarmersFriend.FarmerFrd.service.orgProductService;

@Service
public class orgProductServiceImpl implements orgProductService {
	
	@Autowired
	orgProductRepository opRepo;
	
	@Autowired
	FarmerRepository fRepo;
	
	@Override
	public List<orgProduct> getAllProducts() {
		return opRepo.findAll();
	}

	@Override
	public orgProduct getProductById(int pId) {
	 return opRepo.findById(pId).orElseThrow(()-> new ProductNotFoundException("Please enter valid Product id"));
	}



}
