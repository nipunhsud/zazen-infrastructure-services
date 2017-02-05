package com.zazen.infrastructure.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zazen.infrastructure.v1.service.QuestionService;
import com.zazen.infrastructure.v1.vo.QuestionRequestVO;



@Controller
public class QuestionController {

	Logger log= LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public ResponseEntity<JsonNode> postQuestion( @RequestBody QuestionRequestVO questionRequest) throws Exception{
		JsonNode jsonNode = null;
		jsonNode = questionService.addQuestion(questionRequest);
		return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.OK);
	}
	
	@RequestMapping(value="/questions/{id}" , method = RequestMethod.GET)
	public void getQuestionById( @PathVariable("questionId") String questionId){
		
	}
	
}
