package com.kafka.operations.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kafka.operations.exception.ErrorResponse;
import com.kafka.operations.exception.KafkaOperationsBaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(KafkaOperationsBaseException.class)
	public ResponseEntity<ErrorResponse> handleBaseException(KafkaOperationsBaseException e) {
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorStrCode()), e.getHttpStatus());
	}

	// To handle uncaught exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleUnCaughtException(Exception e) {
		LOGGER.error(e.getMessage(), e);
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getCause().getMessage()),
				HttpStatus.EXPECTATION_FAILED);
	}

}
