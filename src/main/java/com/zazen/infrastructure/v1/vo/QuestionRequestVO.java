package com.zazen.infrastructure.v1.vo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class QuestionRequestVO {
	
	@JsonProperty("question")
	@NotNull
	private String question;
	
	@JsonProperty("latitude")
	@NotNull
	private String locationLatitue;
	
	@JsonProperty("longitude")
	@NotNull
	private String locationLongitute;
	
	@JsonProperty("deviceId")
	@NotNull
	private String deviceId;
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(String questionTag) {
		this.questionTag = questionTag;
	}

	@JsonProperty("timeStamp")
	@NotNull
	private String timeStamp;
	
	
	@JsonProperty("tag")
	private String questionTag;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getLocationLatitue() {
		return locationLatitue;
	}

	public void setLocationLatitue(String locationLatitue) {
		this.locationLatitue = locationLatitue;
	}

	public String getLocationLongitute() {
		return locationLongitute;
	}

	public void setLocationLongitute(String locationLongitute) {
		this.locationLongitute = locationLongitute;
	}
	
	
	
	

}
