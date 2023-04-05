package com.productManagement.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.productManagement.constants.Constants;
import com.productManagement.constants.ResponseStatus;

import lombok.Getter;

@Getter
@JsonInclude(value = Include.NON_NULL)
public class BaseResponse implements Serializable {
	private static final long serialVersionUID = -4364130531733518193L;

	@JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
	private final LocalDateTime timestamp;
	private final String status;
	private final String message;
	private final Map<String, String> fieldError;
	private final Object data;

	/**
	 * @param : status an object of type "ResponseStatus" which presumably
	 *          represents the status of the response.
	 * @param : message a string that contains a message related to the response.
	 * @param : fieldError a map that contains any field errors related to the
	 *          response.
	 * @param : data an object that contains any data related to the response.
	 *          <p>
	 *          The constructor sets the "timestamp" property to the current date
	 *          and time
	 *          <p>
	 *          <p>
	 *          After setting these properties, the constructor checks whether the
	 *          "status" property is empty. If it is, it throws an
	 *          "InternalException"
	 *          <p>
	 */
	public BaseResponse(ResponseStatus status, String message, Map<String, String> fieldError, Object data) {
		this.timestamp = LocalDateTime.now();
		this.status = status.getResponseMessage();
		this.message = message;
		this.fieldError = fieldError;
		this.data = data;
	}

}
