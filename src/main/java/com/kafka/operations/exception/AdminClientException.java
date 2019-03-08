package com.kafka.operations.exception;

import org.springframework.http.HttpStatus;

public class AdminClientException extends KafkaOperationsBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2604829848092874870L;

	public AdminClientException(String msg, String errorStrCode) {
		super(msg, errorStrCode, HttpStatus.EXPECTATION_FAILED);
	}

	public AdminClientException(String msg, String errorStrCode, HttpStatus httpStatus) {
		super(msg, errorStrCode, httpStatus);
	}

}
