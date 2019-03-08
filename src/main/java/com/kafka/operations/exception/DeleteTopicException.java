package com.kafka.operations.exception;

import org.springframework.http.HttpStatus;

public class DeleteTopicException extends KafkaOperationsBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3172648671275935198L;

	public DeleteTopicException(String msg, String errorStrCode) {
		super(msg, errorStrCode, HttpStatus.EXPECTATION_FAILED);
	}
	
	public DeleteTopicException(String msg, String errorStrCode, HttpStatus httpStatus) {
		super(msg, errorStrCode, httpStatus);
	}

}
