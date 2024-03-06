package com.FarmersFriend.FarmerFrd.service;

import java.util.List;


public interface OrderService {
	void makeOrder(int fId,int pId);
	
	List<Object[]> getOrdHis(int fId);
}
