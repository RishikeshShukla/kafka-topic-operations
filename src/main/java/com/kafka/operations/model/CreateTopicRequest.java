package com.kafka.operations.model;

import java.io.Serializable;

public class CreateTopicRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8799199205949832303L;
	private short noOfReplications;
	private String topicName;
	private int noOfPartitions;

	public CreateTopicRequest(short noOfReplications, String topicName, int noOfPartitions) {
		super();
		this.noOfReplications = noOfReplications;
		this.topicName = topicName;
		this.setNoOfPartitions(noOfPartitions);
	}

	public CreateTopicRequest() {

	}

	public short getNoOfReplications() {
		return noOfReplications;
	}

	public void setNoOfReplications(short noOfReplications) {
		this.noOfReplications = noOfReplications;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getNoOfPartitions() {
		return noOfPartitions;
	}

	public void setNoOfPartitions(int noOfPartitions) {
		this.noOfPartitions = noOfPartitions;
	}

	@Override
	public String toString() {
		return "CreateTopicRequest [noOfReplications=" + noOfReplications + ", topicName=" + topicName
				+ ", noOfPartitions=" + noOfPartitions + "]";
	}

}
