package com.kafka.operations.model;

import java.io.Serializable;
import java.util.List;

public class TopicDescriptionResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5215288416635635642L;
	private String topicName;
	private boolean internal;
	private List<PartitionInfo> partitionInfo;
	private int partitionCount;
	private int replicationFactor;

	public TopicDescriptionResponse() {

	}

	public TopicDescriptionResponse(String topicName, boolean internal, List<PartitionInfo> partitionInfo,
			int partitionCount, int replicationFactor) {
		super();
		this.topicName = topicName;
		this.internal = internal;
		this.partitionInfo = partitionInfo;
		this.partitionCount = partitionCount;
		this.replicationFactor = replicationFactor;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	public List<PartitionInfo> getPartitionInfo() {
		return partitionInfo;
	}

	public void setPartitionInfo(List<PartitionInfo> partitionInfo) {
		this.partitionInfo = partitionInfo;
	}

	public int getPartitionCount() {
		return partitionCount;
	}

	public void setPartitionCount(int partitionCount) {
		this.partitionCount = partitionCount;
	}

	public int getReplicationFactor() {
		return replicationFactor;
	}

	public void setReplicationFactor(int replicationFactor) {
		this.replicationFactor = replicationFactor;
	}

	@Override
	public String toString() {
		return "TopicDescriptionResponse [topicName=" + topicName + ", internal=" + internal + ", partitionInfo="
				+ partitionInfo + ", partitionCount=" + partitionCount + ", replicationFactor=" + replicationFactor
				+ "]";
	}

}
