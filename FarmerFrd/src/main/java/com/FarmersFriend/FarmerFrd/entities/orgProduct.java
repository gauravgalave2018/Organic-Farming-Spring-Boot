package com.FarmersFriend.FarmerFrd.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class orgProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	
	 @Column(length=15,nullable=false)
	 private String name;
	 
		@Column(length=1000)
		 private String description;
		   
		 @Column(name = "price", nullable = false)
		 private double price;
	 
	 
		 @OneToMany(mappedBy = "product") // One orgProduct can be associated with many orders
		    @JsonManagedReference
		  private List<Order> orders;


		public int getpId() {
			return pId;
		}


		public void setpId(int pId) {
			this.pId = pId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public List<Order> getOrders() {
			return orders;
		}


		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}


		}
