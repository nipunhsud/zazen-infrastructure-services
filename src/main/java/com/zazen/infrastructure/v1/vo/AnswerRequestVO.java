package com.zazen.infrastructure.v1.vo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zazen.infrastructure.v1.pojos.Answer;

public class AnswerRequestVO {
	
	@JsonProperty("answer")
	@NotNull
	private String answer;
	
	@JsonProperty("question")
	@NotNull
	private String questionId;
	
	@JsonProperty("user")
	private String userId;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
//	public Answer copyTo(AnswerRequestVO answerRequest){
//		Answer answer = new Answer();
//		answer.setCreatedDate(answerRequest.ge);
//		return null;
//	}
//	
	
}
