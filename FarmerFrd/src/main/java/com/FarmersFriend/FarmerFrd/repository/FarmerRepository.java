package com.FarmersFriend.FarmerFrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FarmersFriend.FarmerFrd.entities.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
	public Farmer findByEmail(String email);
}


