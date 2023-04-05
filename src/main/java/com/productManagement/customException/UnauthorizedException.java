package com.productManagement.customException;

public class UnauthorizedException extends RuntimeException{

	private static final long serialVersionUID = 1045967129485493759L;
	
	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnauthorizedException(String message) {
		super(message);
	}

}
