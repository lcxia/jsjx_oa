package com.lhhy.bean;

public class Contract {
	private int contractId;
	private String contractCode;
	private String contractDate;
	private String contractIndustry;
	private String contractDevice;
	private String contractOrder;
	private String contractComment;
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getContractIndustry() {
		return contractIndustry;
	}
	public void setContractIndustry(String contractIndustry) {
		this.contractIndustry = contractIndustry;
	}
	public String getContractDevice() {
		return contractDevice;
	}
	public void setContractDevice(String contractDevice) {
		this.contractDevice = contractDevice;
	}
	public String getContractOrder() {
		return contractOrder;
	}
	public void setContractOrder(String contractOrder) {
		this.contractOrder = contractOrder;
	}
	public String getContractComment() {
		return contractComment;
	}
	public void setContractComment(String contractComment) {
		this.contractComment = contractComment;
	}
	
	public Contract(int contractId,String contractCode,String contractDate,String contractIndustry,String contractDevice,String contractOrder,String contractComment){
		super();
		this.contractId = contractId;
		this.contractCode = contractCode;
		this.contractDate = contractDate;
		this.contractIndustry = contractIndustry;
		this.contractDevice = contractDevice;
		this.contractOrder = contractOrder;
		this.contractComment = contractComment;
	}
	
	public Contract(){
		super();
	}

}
