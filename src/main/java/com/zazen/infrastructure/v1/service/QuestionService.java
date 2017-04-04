package com.zazen.infrastructure.v1.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.vo.QuestionRequestVO;


@Service
public class QuestionService {

	Logger log= LoggerFactory.getLogger(QuestionService.class);
	
	public JsonNode addQuestion(QuestionRequestVO questionRequest) throws Exception{
		JsonNode jsonNode=null;
		
		return jsonNode;
	}
	
	public List<User> getUsersAroundQuestion(Question question){
		//#TODO gets the list of lat and long around the question 
		// based on the above list, gets the users
		// once the users are returned, use fcm service to send the question to it.
		return null;
	}
	
}

