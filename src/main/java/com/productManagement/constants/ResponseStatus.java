package com.productManagement.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
	SUCCESS("Success"), FAILED("Failed");

	private final String responseMessage;
}
