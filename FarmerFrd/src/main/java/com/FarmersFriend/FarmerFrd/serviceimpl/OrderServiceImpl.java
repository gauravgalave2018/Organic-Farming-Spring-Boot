package com.FarmersFriend.FarmerFrd.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FarmersFriend.FarmerFrd.entities.Farmer;
import com.FarmersFriend.FarmerFrd.entities.Order;
import com.FarmersFriend.FarmerFrd.entities.orgProduct;
import com.FarmersFriend.FarmerFrd.exception.FarmerNotFoundException;
import com.FarmersFriend.FarmerFrd.exception.ProductNotFoundException;
import com.FarmersFriend.FarmerFrd.repository.FarmerRepository;
import com.FarmersFriend.FarmerFrd.repository.OrderRepository;
import com.FarmersFriend.FarmerFrd.repository.orgProductRepository;
import com.FarmersFriend.FarmerFrd.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	orgProductRepository opRepo;
	
	@Autowired
	FarmerRepository fRepo;
	
	@Autowired 
	OrderRepository oRepo;

	
	//Place order
	@Override
	public void makeOrder(int fId, int pId) {
		Farmer farmer =fRepo.findById(fId).orElseThrow(()-> new FarmerNotFoundException("Please enter valid Farmer id"));
		orgProduct product=opRepo.findById(pId).orElseThrow(()-> new ProductNotFoundException("Please enter valid Product id"));
		
		Order neworder=new Order();
		neworder.setFarmer(farmer);
		neworder.setProduct(product);
		neworder.setOrderTimestamp(LocalDateTime.now());
		oRepo.save(neworder);
	}


	@Override
	public List<Object[]> getOrdHis(int fId) {
		return oRepo.findOrderDetails(fId);
	}
	

	
}
