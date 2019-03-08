package com.kafka.operations.util;

public enum ErrorCodes {
	CREATE_TOPIC_ERROR(1), DELETE_TOPIC_ERROR(2), IS_TOPIC_EXIST_ERROR(3), DESCRIBE_TOPIC_ERROR(4),
	ADMIN_CLIENT_ERROR(5);

	final int code;

	ErrorCodes(int code) {
		this.code = code;
	}

	public String getCode() {
		return "kafka_topic_operations_error_" + code;
	}

}
