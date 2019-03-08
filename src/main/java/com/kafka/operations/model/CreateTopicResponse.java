package com.kafka.operations.model;

import java.io.Serializable;

public class CreateTopicResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9177850779421188826L;
	private String topicName;

	public CreateTopicResponse() {
	}

	public CreateTopicResponse(String topicName) {
		super();
		this.topicName = topicName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
