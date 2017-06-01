package com.lhhy.bean;

public class Quote {
	private int quoteId;
	private String quoteDate;
	private String quoteOrder;
	private String quoteIndustry;
	private String quoteDevice;
	private String quoteTake;
	private String quoteContent;
	private double quoteNoTaxPrice;
	private double quoteTaxPrice;
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public String getQuoteDate() {
		return quoteDate;
	}
	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}
	public String getQuoteOrder() {
		return quoteOrder;
	}
	public void setQuoteOrder(String quoteOrder) {
		this.quoteOrder = quoteOrder;
	}
	public String getQuoteIndustry() {
		return quoteIndustry;
	}
	public void setQuoteIndustry(String quoteIndustry) {
		this.quoteIndustry = quoteIndustry;
	}
	public String getQuoteDevice() {
		return quoteDevice;
	}
	public void setQuoteDevice(String quoteDevice) {
		this.quoteDevice = quoteDevice;
	}
	public String getQuoteTake() {
		return quoteTake;
	}
	public void setQuoteTake(String quoteTake) {
		this.quoteTake = quoteTake;
	}
	public String getQuoteContent() {
		return quoteContent;
	}
	public void setQuoteContent(String quoteContent) {
		this.quoteContent = quoteContent;
	}
	public double getQuoteNoTaxPrice() {
		return quoteNoTaxPrice;
	}
	public void setQuoteNoTaxPrice(double quoteNoTaxPrice) {
		this.quoteNoTaxPrice = quoteNoTaxPrice;
	}
	public double getQuoteTaxPrice() {
		return quoteTaxPrice;
	}
	public void setQuoteTaxPrice(double quoteTaxPrice) {
		this.quoteTaxPrice = quoteTaxPrice;
	}
	public Quote(int quoteId, String quoteDate, String quoteOrder, String quoteIndustry, String quoteDevice,
			String quoteTake, String quoteContent,double quoteNoTaxPrice, double quoteTaxPrice) {
		super();
		this.quoteId = quoteId;
		this.quoteDate = quoteDate;
		this.quoteOrder = quoteOrder;
		this.quoteIndustry = quoteIndustry;
		this.quoteDevice = quoteDevice;
		this.quoteTake = quoteTake;
		this.quoteContent = quoteContent;
		this.quoteNoTaxPrice = quoteNoTaxPrice;
		this.quoteTaxPrice = quoteTaxPrice;
	}
	public Quote() {
		super();
	}

}
