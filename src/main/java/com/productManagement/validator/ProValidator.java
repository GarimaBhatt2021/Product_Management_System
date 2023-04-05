package com.productManagement.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import com.productManagement.customException.InvalidDataException;
import com.productManagement.entities.Product;
import com.productManagement.request.AddProductRequest;
import com.productManagement.service.MessageService;


@Service
public class ProValidator {

	private final MessageService messageService;

	@Autowired
	public ProValidator(MessageService messageService) {
		super();
		this.messageService = messageService;
	}

	public void abvalidateRequest(AddProductRequest addProductRequest, BindingResult bindingResult) {
		Map<String, String> errorMap = new HashMap<>();
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError error : fieldErrors) {
				errorMap.put(error.getField(), messageService.getMessage(error.getDefaultMessage()));
			}
		}
		if (!errorMap.isEmpty()) {
			throw new InvalidDataException(errorMap, HttpStatus.BAD_REQUEST, messageService.getMessage("invalid.data"));
		}
	}
		
	
	public void apbvalidateRequest(AddProductRequest request,Product product, BindingResult bindingResult) {
		Map<String, String> errorMap = new HashMap<>();
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError error : fieldErrors) {
				errorMap.put(error.getField(), messageService.getMessage(error.getDefaultMessage()));
			}
		}
		if (!errorMap.isEmpty()) {
			throw new InvalidDataException(errorMap, HttpStatus.BAD_REQUEST, messageService.getMessage("invalid.data"));
		}
	}
		
	public void validateRequest(Product product, BindingResult bindingResult) {
		Map<String, String> errorMap = new HashMap<>();
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError error : fieldErrors) {
				errorMap.put(error.getField(), messageService.getMessage(error.getDefaultMessage()));
			}
		}
		if (!errorMap.isEmpty()) {
			throw new InvalidDataException(errorMap, HttpStatus.BAD_REQUEST, messageService.getMessage("invalid.data"));
		}
	}
}

