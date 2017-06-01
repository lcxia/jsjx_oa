package com.lhhy.bean;

public class ContractStatis {
	private int contractStatisId;
	private String contractStatisDate;
	
	public int getContractStatisId() {
		return contractStatisId;
	}
	public void setContractStatisId(int contractStatisId) {
		this.contractStatisId = contractStatisId;
	}
	
	public String getContractStatisDate() {
		return contractStatisDate;
	}
	public void setContractStatisDate(String contractStatisDate) {
		this.contractStatisDate = contractStatisDate;
	}
	
	public ContractStatis(int contractStatisId,String contractStatisDate) {
		super();
		this.contractStatisId = contractStatisId;
		this.contractStatisDate=contractStatisDate;
		
	}
	public ContractStatis() {
		super();
	}

}

