package com.lhhy.bean;

public class Maintain {
	//成员变量
	private int maintainId;
	private String maintainDate;
	private String maintainEvection;
	
	private int maintainClient;
	private int maintainDevice;
	private String maintainRely;
	private String maintainContinue;
	private String maintainPerson;
	//提供geter和seter方法
	public int getMaintainId() {
		return maintainId;
	}
	public void setMaintainId(int maintainId) {
		this.maintainId = maintainId;
	}
	public String getMaintainDate() {
		return maintainDate;
	}
	public void setMaintainDate(String maintainDate) {
		this.maintainDate = maintainDate;
	}
	public String getMaintainEvection() {
		return maintainEvection;
	}
	public void setMaintainEvection(String maintainEvection) {
		this.maintainEvection = maintainEvection;
	}
	public int getMaintainClient() {
		return maintainClient;
	}
	public void setMaintainClient(int maintainClient) {
		this.maintainClient = maintainClient;
	}
	public int getMaintainDevice() {
		return maintainDevice;
	}
	public void setMaintainDevice(int maintainDevice) {
		this.maintainDevice = maintainDevice;
	}
	public String getMaintainRely() {
		return maintainRely;
	}
	public void setMaintainRely(String maintainRely) {
		this.maintainRely = maintainRely;
	}
	public String getMaintainContinue() {
		return maintainContinue;
	}
	public void setMaintainContinue(String maintainContinue) {
		this.maintainContinue = maintainContinue;
	}
	public String getMaintainPerson() {
		return maintainPerson;
	}
	public void setMaintainPerson(String maintainPerson) {
		this.maintainPerson = maintainPerson;
	}
	public Maintain(int maintainId, String maintainEvection,String maintainDate,int maintainClient,int maintainDevice,String maintainRely,String maintainContinue,String maintainPerson) {
		super();
		this.maintainId = maintainId;
		this.maintainEvection = maintainEvection;
		this.maintainDate = maintainDate;
		this.maintainClient = maintainClient;
		this.maintainDevice = maintainDevice;
		this.maintainRely = maintainRely;
		this.maintainContinue = maintainContinue;
		this.maintainPerson = maintainPerson;
	}
	//构造方法
	public Maintain(int maintainId, String maintainEvection) {
		super();
		this.maintainId = maintainId;
		this.maintainEvection = maintainEvection;
	}	
	public Maintain() {
		super();
	}
}
