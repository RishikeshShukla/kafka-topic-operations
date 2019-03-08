package com.kafka.operations.model;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.Node;

public class PartitionInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7205138846150256235L;
	private int partition;
	private Node leader;
	private List<NodeInfo> replicas;
	private List<NodeInfo> isr;

	public PartitionInfo() {
		super();
	}

	public PartitionInfo(int partition, Node leader, List<Node> replicas, List<Node> isr) {
		super();
		this.partition = partition;
		this.leader = leader;
		this.replicas = convertNodeToNodeInfo(replicas);
		this.isr = convertNodeToNodeInfo(replicas);
	}

	private List<NodeInfo> convertNodeToNodeInfo(List<Node> replicas) {

		List<NodeInfo> nodeInfoList = replicas.stream()
				.map(node -> new NodeInfo(node.id(), node.host(), node.port(), node.rack()))
				.collect(Collectors.toList());

		return nodeInfoList;
	}

	public int getPartition() {
		return partition;
	}

	public void setPartition(int partition) {
		this.partition = partition;
	}

	public Node getLeader() {
		return leader;
	}

	public void setLeader(Node leader) {
		this.leader = leader;
	}

	public List<NodeInfo> getReplicas() {
		return replicas;
	}

	public void setReplicas(List<NodeInfo> replicas) {
		this.replicas = replicas;
	}

	public List<NodeInfo> getIsr() {
		return isr;
	}

	public void setIsr(List<NodeInfo> isr) {
		this.isr = isr;
	}

	@Override
	public String toString() {
		return "PartitionInfo [partition=" + partition + ", leader=" + leader + ", replicas=" + replicas + ", isr="
				+ isr + "]";
	}

}
