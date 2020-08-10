package com.rob.restservices.exceptions;

import java.io.Serializable;

public class PortfolioNotFoundException extends Exception implements Serializable{
	private static final long serialVersionUID = -3835068248151851737L;

	public PortfolioNotFoundException(String message) {
		super(message);
	}
	
}
