package com.kafka.operations.exception;

import org.springframework.http.HttpStatus;

public class KafkaOperationsBaseException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 361468845237836662L;

	private String errorStrCode;
	private HttpStatus httpStatus;

	public KafkaOperationsBaseException(String msg, String errorStrCode, HttpStatus httpStatus) {
		super(msg);
		this.errorStrCode = errorStrCode;
		this.setHttpStatus(httpStatus);
	}

	public String getErrorStrCode() {
		return errorStrCode;
	}

	public void setErrorStrCode(String errorStrCode) {
		this.errorStrCode = errorStrCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
