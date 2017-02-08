package com.zazen.infrastructure.v1.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.zazen.infrastructure.v1.pojos.Answer;
import com.zazen.infrastructure.v1.repository.AnswerRepository;


public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public void addAnswer(Answer answer){
		answerRepository.save(answer);
	}
}
