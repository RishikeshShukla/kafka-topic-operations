package com.kafka.operations.exception;

import org.springframework.http.HttpStatus;

public class CreateTopicException extends KafkaOperationsBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3583005324274634393L;

	public CreateTopicException(String msg, String errorStrCode) {
		super(msg, errorStrCode, HttpStatus.EXPECTATION_FAILED);
	}

	public CreateTopicException(String msg, String errorStrCode, HttpStatus httpStatus) {
		super(msg, errorStrCode, httpStatus);
	}

}
