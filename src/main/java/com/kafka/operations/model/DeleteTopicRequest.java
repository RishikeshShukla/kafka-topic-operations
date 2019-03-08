package com.kafka.operations.model;

import java.io.Serializable;

public class DeleteTopicRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String topicName;

	public DeleteTopicRequest() {

	}

	public DeleteTopicRequest(String topicName) {
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
