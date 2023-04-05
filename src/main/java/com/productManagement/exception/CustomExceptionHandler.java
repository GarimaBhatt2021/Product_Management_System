package com.productManagement.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productManagement.constants.ResponseStatus;
import com.productManagement.customException.InvalidDataException;
import com.productManagement.customException.ResourceNotFoundException;
import com.productManagement.customException.UnauthorizedException;
import com.productManagement.request.BaseResponse;


@RestControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<BaseResponse> handleResourceNotFoundException(ResourceNotFoundException rse) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new BaseResponse(ResponseStatus.FAILED, rse.getErrorMessage(), null, null));
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<BaseResponse> handleResourceNotFoundException(EmptyResultDataAccessException rse) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new BaseResponse(ResponseStatus.FAILED, "ID does not found/ Already deleted", null, null));
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<BaseResponse> handleResourceNotFoundException(NoSuchElementException rse) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new BaseResponse(ResponseStatus.FAILED, "Data not found", null, null));
	}
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<BaseResponse> handleInvalidDataException(InvalidDataException ine) {
		return ResponseEntity.status(ine.gethttpStatus())
				.body(new BaseResponse(ResponseStatus.FAILED, ine.getMessage(), ine.getErrorMap(), null));
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<BaseResponse> handleUnauthorizedException(final UnauthorizedException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new BaseResponse(ResponseStatus.FAILED, e.getMessage(), null, null));
	}

}
