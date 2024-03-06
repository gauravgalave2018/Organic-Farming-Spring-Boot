package com.FarmersFriend.FarmerFrd.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.FarmersFriend.FarmerFrd.service.OrderService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OrderController {
	
	@Autowired
	OrderService os;

	
	@PostMapping("/order")
	public String makeOrder(@RequestParam int fId,@RequestParam int pId){
		os.makeOrder(fId, pId);
		return "Order Placed Successfully";
	}
	
	@GetMapping("/orderHistory")
	public List<Object[]> getHistory(@RequestParam int fId){
		return os.getOrdHis(fId);
	}
}
