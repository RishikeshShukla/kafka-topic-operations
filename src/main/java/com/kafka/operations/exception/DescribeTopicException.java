package com.kafka.operations.exception;

import org.springframework.http.HttpStatus;

public class DescribeTopicException extends KafkaOperationsBaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5839072111103683123L;

	public DescribeTopicException(String msg, String errorStrCode, HttpStatus httpStatus) {
		super(msg, errorStrCode, httpStatus);
	}
	
	public DescribeTopicException(String msg, String errorStrCode) {
		super(msg, errorStrCode, HttpStatus.EXPECTATION_FAILED);
	}
	
	

}
