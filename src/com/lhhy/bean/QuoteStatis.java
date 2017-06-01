package com.lhhy.bean;

public class QuoteStatis {
	private int quoteStatisId;
	private String clientName;
	private String clientType;
	private String quoteStatisDate;
	
	public int getQuoteStatisId() {
		return quoteStatisId;
	}
	public void setQuoteStatisId(int quoteStatisId) {
		this.quoteStatisId = quoteStatisId;
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
	public String getQuoteStatisDate() {
		return quoteStatisDate;
	}
	public void setQuoteStatisDate(String quoteStatisDate) {
		this.quoteStatisDate = quoteStatisDate;
	}
	
	public QuoteStatis(int quoteStatisId, String clientName, String clientType,String quoteStatisDate) {
		super();
		this.quoteStatisId = quoteStatisId;
		this.clientName = clientName;
		this.clientType = clientType;
		this.quoteStatisDate=quoteStatisDate;
		
	}
	public QuoteStatis() {
		super();
	}

}
