package com.productManagement.customException;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class InvalidDataException extends RuntimeException{

	private static final long serialVersionUID = -1778321995237067174L;
	private Map<String, String> errorMap;
	private HttpStatus httpStatus;
	private String message;

	public InvalidDataException(Map<String, String> errorMap, HttpStatus httpStatus, String message) {
		super();
		this.errorMap = errorMap;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public HttpStatus gethttpStatus() {
		return httpStatus;
	}

	public void sethttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

