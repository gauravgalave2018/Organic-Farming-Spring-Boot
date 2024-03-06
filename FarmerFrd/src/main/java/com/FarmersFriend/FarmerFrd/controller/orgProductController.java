package com.FarmersFriend.FarmerFrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FarmersFriend.FarmerFrd.entities.orgProduct;
import com.FarmersFriend.FarmerFrd.service.orgProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class orgProductController {
	
	@Autowired
	private orgProductService orgProductService;
	
	
	@GetMapping("/fetchAllProducts")
	public ResponseEntity<List<orgProduct>>fetchAllProducts() {
		return new ResponseEntity<List<orgProduct>>(orgProductService.getAllProducts(), HttpStatus.OK);
	}
}
