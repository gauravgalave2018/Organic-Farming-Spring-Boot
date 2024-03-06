package com.FarmersFriend.FarmerFrd.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_order")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oId;
	
	@Column(name = "order_timestamp")
    private LocalDateTime orderTimestamp;
	
    @ManyToOne
    @JoinColumn(name = "fId")
    private Farmer farmer;

    @ManyToOne // Many orders can have one orgProduct
    @JoinColumn(name = "pId") // Foreign key column in Order table
    @JsonBackReference
    private orgProduct product;


	public int getoId() {
		return oId;
	}


	public void setoId(int oId) {
		this.oId = oId;
	}


	public LocalDateTime getOrderTimestamp() {
		return orderTimestamp;
	}


	public void setOrderTimestamp(LocalDateTime orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}


	public Farmer getFarmer() {
		return farmer;
	}


	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}


	public orgProduct getProduct() {
		return product;
	}


	public void setProduct(orgProduct product) {
		this.product = product;
	}

}
