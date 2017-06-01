package com.lhhy.bean;

public class ServiceComplain {
	//成员变量
private int serviceComplainId;
private String serviceComplainCode;
private int serviceComplainClient;
private String serviceComplainDoneDate;
private String serviceComplainLetterDate;
private String serviceComplainLetterReceive;
private String serviceComplainTake;
private int serviceComplainDevice;
//提供geter和seter方法
	public int getServiceComplainId() {
		return serviceComplainId;
	}
	public void setServiceComplainId(int serviceComplainId) {
		this.serviceComplainId = serviceComplainId;
	}
	public String getServiceComplainCode() {
		return serviceComplainCode;
	}
	public void setServiceComplainCode(String serviceComplainCode) {
		this.serviceComplainCode = serviceComplainCode;
	}
	
	public ServiceComplain(int serviceComplainId, String serviceComplainCode) {
		super();
		this.serviceComplainId = serviceComplainId;
		this.serviceComplainCode = serviceComplainCode;
	}
	  
	
	public int getServiceComplainClient() {
		return serviceComplainClient;
	}
	public void setServiceComplainClient(int serviceComplainClient) {
		this.serviceComplainClient = serviceComplainClient;
	}
	public String getServiceComplainDoneDate() {
		return serviceComplainDoneDate;
	}
	public void setServiceComplainDoneDate(String serviceComplainDoneDate) {
		this.serviceComplainDoneDate = serviceComplainDoneDate;
	}
	public String getServiceComplainLetterDate() {
		return serviceComplainLetterDate;
	}
	public void setServiceComplainLetterDate(String serviceComplainLetterDate) {
		this.serviceComplainLetterDate = serviceComplainLetterDate;
	}
	public String getServiceComplainLetterReceive() {
		return serviceComplainLetterReceive;
	}
	public void setServiceComplainLetterReceive(String serviceComplainLetterReceive) {
		this.serviceComplainLetterReceive = serviceComplainLetterReceive;
	}
	public String getServiceComplainTake() {
		return serviceComplainTake;
	}
	public void setServiceComplainTake(String serviceComplainTake) {
		this.serviceComplainTake = serviceComplainTake;
	}
	public int getServiceComplainDevice() {
		return serviceComplainDevice;
	}
	public void setServiceComplainDevice(int serviceComplainDevice) {
		this.serviceComplainDevice = serviceComplainDevice;
	}
	//构造方法
	public ServiceComplain(int serviceComplainId, String serviceComplainCode,int serviceComplainClient,String serviceComplainDoneDate,String serviceComplainLetterDate,String serviceComplainLetterReceive,String serviceComplainTake,int serviceComplainDevice) {
		super();
	
	this.serviceComplainId = serviceComplainId;
	this.serviceComplainCode = serviceComplainCode;
	this.serviceComplainClient = serviceComplainClient;
	this.serviceComplainDoneDate = serviceComplainDoneDate;
	this.serviceComplainLetterDate = serviceComplainLetterDate;
	this.serviceComplainLetterReceive = serviceComplainLetterReceive;
	this.serviceComplainTake = serviceComplainTake;
	this.serviceComplainDevice = serviceComplainDevice;
	}
public ServiceComplain() {
	super();
}
}

