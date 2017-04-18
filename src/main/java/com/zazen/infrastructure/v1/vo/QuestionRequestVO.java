package com.zazen.infrastructure.v1.vo;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zazen.infrastructure.v1.pojos.Question;


public class QuestionRequestVO {
	
	@Autowired
	private Question question;
	
	@JsonProperty("query")
	@NotNull
	private String query;
	
	@JsonProperty("latitude")
	@NotNull
	private BigDecimal locationLatitue;
	
	@JsonProperty("longitude")
	@NotNull
	private BigDecimal locationLongitute;
	
	@JsonProperty("deviceId")
	@NotNull
	private String deviceId;
	
	@JsonProperty("userId")
	@NotNull
	private String UserId;
	
	@JsonProperty("locationName")
	private String questionTag;
	
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
	

	public String getQuery() {
		return query;
	}

	public void setQuerty(String query) {
		this.query = query;
	}

	public BigDecimal getLocationLatitue() {
		return locationLatitue;
	}

	public void setLocationLatitue(BigDecimal locationLatitue) {
		this.locationLatitue = locationLatitue;
	}

	public BigDecimal getLocationLongitute() {
		return locationLongitute;
	}

	public void setLocationLongitute(BigDecimal locationLongitute) {
		this.locationLongitute = locationLongitute;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}
	
	
	public Question mapToQuestion(QuestionRequestVO questionRequest){
		question = new Question();
		this.question.setLatitude(questionRequest.getLocationLatitue());
		this.question.setLongitude(questionRequest.getLocationLongitute());
		this.question.setQuery(questionRequest.getQuery());
		this.question.setLocationName(questionRequest.getQuestionTag());
		this.question.setCreateTime();
		this.question.setLastModified();
		return this.question;
	}
	

}
