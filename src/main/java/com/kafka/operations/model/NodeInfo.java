package com.kafka.operations.model;

import java.io.Serializable;

public class NodeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 910100057762316045L;
	private int id;
	private String idString;
	private String host;
	private int port;
	private String rack;

	public NodeInfo(int id, String host, int port, String rack) {
		this.id = id;
		this.idString = Integer.toString(id);
		this.host = host;
		this.port = port;
		this.rack = rack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	@Override
	public String toString() {
		return "NodeInfo [id=" + id + ", idString=" + idString + ", host=" + host + ", port=" + port + ", rack=" + rack
				+ "]";
	}

}
