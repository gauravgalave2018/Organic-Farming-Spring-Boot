package com.FarmersFriend.FarmerFrd.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	
		private HttpStatus status;
		private String message;
	
		public ErrorMessage() {
		}
		
		public HttpStatus getStatus() {
			return status;
		}
		public void setStatus(HttpStatus status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}

