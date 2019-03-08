package com.kafka.operations.model;

import java.io.Serializable;

public class TopicRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String topicName;

	public TopicRequest() {
	}

	public TopicRequest(String topicName) {
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
