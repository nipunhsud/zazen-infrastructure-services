package com.zazen.infrastructure.v1.service;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionRequest {
	
	@JsonProperty("Question")
	@NotNull
	private String question;
	
	@JsonProperty("Latitude")
	@NotNull
	private String locationLatitue;
	
	@JsonProperty("Longitude")
	@NotNull
	private String locationLongitute;
	
	@JsonProperty("DeviceId")
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

	@JsonProperty("TimeStamp")
	@NotNull
	private String timeStamp;
	
	
	@JsonProperty("Tag")
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
