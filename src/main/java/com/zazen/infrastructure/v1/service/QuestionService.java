package com.zazen.infrastructure.v1.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zazen.infrastructure.v1.vo.QuestionRequest;

@Service
public class QuestionService {

	Logger log= LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public JsonNode addQuestion(QuestionRequest questionRequest) throws Exception{
		JsonNode jsonNode=null;
		
		return jsonNode;
	}
	
}

