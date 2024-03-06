package com.FarmersFriend.FarmerFrd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Farmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fId;
	
	@Column(length=15,nullable=false)
	private String name;
	
	@Column(length=25,nullable=false,unique=true)
	@NotBlank(message = "farmer email is mandatory")
    private String email;
		
	@Column(length=25,nullable=false,unique=true)
	@NotBlank(message = "fill the password")
	private String password;
	
	@Column(length = 12, nullable = false, unique = true)
	@NotNull(message = "farmer number is mandatory")
	private long phone;

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
		
}