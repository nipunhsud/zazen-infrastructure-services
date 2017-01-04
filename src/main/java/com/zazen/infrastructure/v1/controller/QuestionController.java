package com.zazen.infrastructure.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zazen.infrastructure.v1.service.QuestionRequest;
import com.zazen.infrastructure.v1.service.QuestionService;



@Controller
public class QuestionController {

	Logger log= LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private QuestionService questionService;
	
	public ResponseEntity<JsonNode> postQuestion(QuestionRequest questionRequest) throws Exception{
		JsonNode jsonNode=null;
		jsonNode=questionService.addQuestion(questionRequest);
		return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.OK);
		
	}
	
}
