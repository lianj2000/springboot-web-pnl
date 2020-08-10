package com.rob.restservices.exceptions;

import java.util.Date;

//Simple Portfolio error details bean
public class PortfolioErrorDetails {
	
	private Date timestamp;
	private String message;
	private String errordetails;
	
	//Fields Constructor
	public PortfolioErrorDetails(Date timestamp, String message, String errordetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errordetails = errordetails;
	}
	
	//GETTERS
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getErrordetails() {
		return errordetails;
	}
	
	

}
