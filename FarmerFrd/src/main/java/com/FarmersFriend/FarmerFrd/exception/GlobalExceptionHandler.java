package com.FarmersFriend.FarmerFrd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//Farmer Id Not Found
		@ExceptionHandler(FarmerNotFoundException.class)
		public ResponseEntity<ErrorMessage> handleCustomerException(
				FarmerNotFoundException ex, WebRequest request){
			ErrorMessage em = new ErrorMessage();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
		}
		
//		//product ID not found
//		@ExceptionHandler(ProductNotFoundException.class)
//		public ResponseEntity<ErrorMessage> handleProductException(
//				ProductNotFoundException ex, WebRequest request){
//			ErrorMessage em = new ErrorMessage();
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
//		}
		
}
