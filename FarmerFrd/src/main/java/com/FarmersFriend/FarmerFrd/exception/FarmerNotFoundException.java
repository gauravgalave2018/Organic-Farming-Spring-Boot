package com.FarmersFriend.FarmerFrd.exception;

public class FarmerNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FarmerNotFoundException(String messsage) {
		super(messsage);
	}
}

