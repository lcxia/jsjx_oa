package com.lhhy.bean;

public class Cost {
	private int costId;
	private String costDate;
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	public String getCostDate() {
		return costDate;
	}
	public void setCostDate(String costDate) {
		this.costDate = costDate;
	}
	public Cost(int costId, String costDate) {
		super();
		this.setCostId(costId);
		this.setCostDate(costDate);
	}
	public Cost() {
		super();
	}
	
}
