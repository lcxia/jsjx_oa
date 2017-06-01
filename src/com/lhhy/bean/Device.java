package com.lhhy.bean;

public class Device {
	
	private int deviceId;
	private String deviceCode;
	private String deviceMain;
	private String devicePump;
	private String deviceCapacity;
	private double deviceA;
	private double deviceB;
	private double deviceC;
	private double deviceD;
	private double deviceE;
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getDeviceMain() {
		return deviceMain;
	}
	public void setDeviceMain(String deviceMain) {
		this.deviceMain = deviceMain;
	}
	public String getDevicePump() {
		return devicePump;
	}
	public void setDevicePump(String devicePump) {
		this.devicePump = devicePump;
	}
	public String getDeviceCapacity() {
		return deviceCapacity;
	}
	public void setDeviceCapacity(String deviceCapacity) {
		this.deviceCapacity = deviceCapacity;
	}
	public double getDeviceA() {
		return deviceA;
	}
	public void setDeviceA(double deviceA) {
		this.deviceA = deviceA;
	}
	public double getDeviceB() {
		return deviceB;
	}
	public void setDeviceB(double deviceB) {
		this.deviceB = deviceB;
	}
	public double getDeviceC() {
		return deviceC;
	}
	public void setDeviceC(double deviceC) {
		this.deviceC = deviceC;
	}
	public double getDeviceD() {
		return deviceD;
	}
	public void setDeviceD(double deviceD) {
		this.deviceD = deviceD;
	}
	public double getDeviceE() {
		return deviceE;
	}
	public void setDeviceE(double deviceE) {
		this.deviceE = deviceE;
	}
	public Device(int deviceId, String deviceCode, String deviceMain, String devicePump, String deviceCapacity,
			double deviceA, double deviceB, double deviceC, double deviceD, double deviceE) {
		super();
		this.deviceId = deviceId;
		this.deviceCode = deviceCode;
		this.deviceMain = deviceMain;
		this.devicePump = devicePump;
		this.deviceCapacity = deviceCapacity;
		this.deviceA = deviceA;
		this.deviceB = deviceB;
		this.deviceC = deviceC;
		this.deviceD = deviceD;
		this.deviceE = deviceE;
	}
	public Device() {
		super();
	}
}
