package com.productManagement.customException;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3858713168925182355L;
	private String errorMessage;

	public ResourceNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
