package com.zazen.infrastructure.v1.vo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerRequestVO {
	
	@JsonProperty("answer")
	@NotNull
	private String answer;
	
	@JsonProperty("question")
	@NotNull
	private String question;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}
