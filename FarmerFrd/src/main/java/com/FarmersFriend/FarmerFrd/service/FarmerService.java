package com.FarmersFriend.FarmerFrd.service;

import com.FarmersFriend.FarmerFrd.entities.Farmer;


public interface FarmerService {
	Farmer registerFarmer(Farmer farmer);
	
	void removeFarmer(int fId);
	
	Farmer getFarmerDetails(int fId);
	
	Farmer editFarmer(Farmer farmer,int fId);
	
}
