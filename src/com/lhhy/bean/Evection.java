package com.lhhy.bean;

public class Evection {
	private int evectionId;
	private String evectionName;
	private String evectionPlace;
	private String evectionOut;
	private String evectionBack;
	private String evectionComment;
	public int getEvectionId() {
		return evectionId;
	}
	public void setEvectionId(int evectionId) {
		this.evectionId = evectionId;
	}
	public String getEvectionName() {
		return evectionName;
	}
	public void setEvectionName(String evectionName) {
		this.evectionName = evectionName;
	}
	public String getEvectionPlace() {
		return evectionPlace;
	}
	public void setEvectionPlace(String evectionPlace) {
		this.evectionPlace = evectionPlace;
	}
	public String getEvectionOut() {
		return evectionOut;
	}
	public void setEvectionOut(String evectionOut) {
		this.evectionOut = evectionOut;
	}
	public String getEvectionBack() {
		return evectionBack;
	}
	public void setEvectionBack(String evectionBack) {
		this.evectionBack = evectionBack;
	}
	public String getEvectionComment() {
		return evectionComment;
	}
	public void setEvectionComment(String evectionComment) {
		this.evectionComment = evectionComment;
	}
	public Evection(int evectionId,String evectionName,String evectionPlace,String evectionOut,String evectionBack,String evectionComment) {
		super();
		this.evectionId = evectionId;
		this.evectionName = evectionName;
		this.evectionPlace = evectionPlace;
		this.evectionOut = evectionOut;
		this.evectionBack = evectionBack;
		this.evectionComment = evectionComment;
	}
	public Evection() {
		super();
	}
	
	
	

}

