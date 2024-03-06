package com.FarmersFriend.FarmerFrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FarmersFriend.FarmerFrd.entities.Farmer;
import com.FarmersFriend.FarmerFrd.repository.FarmerRepository;
import com.FarmersFriend.FarmerFrd.service.FarmerService;


import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FarmerController {
	
	@Autowired
	FarmerService fs;
	
	@Autowired
	FarmerRepository fRepo;
	
	//resister new Farmer
		@PostMapping("/registerFarmer")
		public ResponseEntity<Farmer> registerUser( @Valid @RequestBody Farmer farmer){
			return new ResponseEntity<Farmer>(fs.registerFarmer(farmer),HttpStatus.CREATED);
		}
		
		//delete user
		@DeleteMapping("/deleteFarmer/{fId}")
		public ResponseEntity<String> deleteFarmer(@PathVariable("fId") int fId){
			fs.removeFarmer(fId);
			return new ResponseEntity<String>("Deleted Farmer Record",HttpStatus.OK);
		}
		
		//updating user
		@PutMapping("/editUser/{fId}")
		public ResponseEntity<Farmer> editFarmer(@Valid @PathVariable("fId") int fId, @RequestBody Farmer farmer){
			return new ResponseEntity<Farmer>(fs.editFarmer(farmer, fId), HttpStatus.OK);
		}
		
		//getFarmerByID
		@GetMapping("/getFarmer/{fId}")
		public ResponseEntity<Farmer> getFarmerDetails(@PathVariable("fId") int fId) {
			return new ResponseEntity<Farmer>(fs.getFarmerDetails(fId),HttpStatus.OK);
		}
	
		//login
		@PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
			Farmer farmer = fRepo.findByEmail(email);

	        if (farmer != null) {
	            
	            if (farmer.getPassword().equals(password)) {
	                String farmerIdString = String.valueOf(farmer.getfId());
	                return ResponseEntity.ok(farmerIdString);
	            } else {
	                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
	        }
	    }
}