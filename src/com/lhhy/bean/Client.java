package com.lhhy.bean;

public class Client {
	private int clientId;
	private String clientName;
	private String clientType;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	public Client(int clientId, String clientName, String clientType) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientType = clientType;
		
	}
	public Client() {
		super();
	}

}