package com.lhhy.bean;

public class Conference {
	private int conferenceId;
	private String conferenceCode;
	private String conferenceDoneDate;
	
	public int getConferenceId() {
		return conferenceId;
	}
	public void setConferenceId(int conferenceId) {
		this.conferenceId = conferenceId;
	}
	public String getConferenceCode() {
		return conferenceCode;
	}
	public void setConferenceCode(String conferenceCode) {
		this.conferenceCode = conferenceCode;
	}
	public String getConferenceDoneDate() {
		return conferenceDoneDate;
	}
	public void setConferenceDoneDate(String conferenceDoneDate) {
		this.conferenceDoneDate = conferenceDoneDate;
	}
	
	public Conference(int conferenceId, String conferenceCode, String conferenceDoneDate) {
		super();
		this.conferenceId = conferenceId;
		this.conferenceCode = conferenceCode;
		this.conferenceDoneDate = conferenceDoneDate;
		
	}
	public Conference() {
		super();
	}

}