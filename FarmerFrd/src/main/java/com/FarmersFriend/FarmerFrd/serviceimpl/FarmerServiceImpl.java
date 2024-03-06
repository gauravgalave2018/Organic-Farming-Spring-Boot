package com.FarmersFriend.FarmerFrd.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FarmersFriend.FarmerFrd.entities.Farmer;
import com.FarmersFriend.FarmerFrd.exception.FarmerNotFoundException;
import com.FarmersFriend.FarmerFrd.repository.FarmerRepository;
import com.FarmersFriend.FarmerFrd.service.FarmerService;



@Service
public class FarmerServiceImpl implements FarmerService{
	
	@Autowired
	FarmerRepository fRepo;

	@Override
	public Farmer registerFarmer(Farmer farmer) {

		return fRepo.save(farmer);
	}

	@Override
	public void removeFarmer(int fId) {
	fRepo.deleteById(fId);
		
	}

	@Override
	public Farmer editFarmer(Farmer farmer, int fId) {
		Farmer newfarmer = fRepo.findById(fId).orElseThrow(()-> new FarmerNotFoundException("Farmer Not exists"));
		newfarmer.setPhone(farmer.getPhone());
		fRepo.save(newfarmer);
		return newfarmer;
	}

	@Override
	public Farmer getFarmerDetails(int fId) {
		return fRepo.findById(fId).orElseThrow(()-> new FarmerNotFoundException("Farmer Not exists"));
	}

}
