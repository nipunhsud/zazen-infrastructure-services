package com.zazen.infrastructure.v1.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.zazen.infrastructure.v1.vo.QuestionRequestVO;


@Service
public class QuestionService {

	Logger log= LoggerFactory.getLogger(QuestionService.class);
	
	public JsonNode addQuestion(QuestionRequestVO questionRequest) throws Exception{
		JsonNode jsonNode=null;
		
		return jsonNode;
	}
	
}

