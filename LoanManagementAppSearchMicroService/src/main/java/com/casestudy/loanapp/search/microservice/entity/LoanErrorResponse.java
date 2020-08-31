package com.casestudy.loanapp.search.microservice.entity;

public class LoanErrorResponse {

	private int status;
	
	private String message;
	
	// default constructor
	public LoanErrorResponse() {
		
	}

	// constructors with fields
	public LoanErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	// define getters/ setters
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
