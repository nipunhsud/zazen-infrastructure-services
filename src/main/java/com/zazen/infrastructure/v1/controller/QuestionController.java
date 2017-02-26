package com.zazen.infrastructure.v1.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.repository.QuestionRepository;
import com.zazen.infrastructure.v1.service.QuestionService;


@Controller
@RequestMapping("questions")
public class QuestionController {

	Logger log= LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService;
	
//	@Autowired
//	private QuestionRepository  questionRespository;
	
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public ResponseEntity<JsonNode> postQuestion( @RequestBody Question question) throws Exception{
		JsonNode jsonNode = null;
		//jsonNode = questionService.addQuestion(questionRequest);
		//questionRespository.save(question);
		return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public void getQuestionById( @PathVariable("questionId") String questionId){
		
	}
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public List<Question> getQuestions(){
		
		List<Question> allQuestions = (List<Question>) questionRespository.findAll();
		return allQuestions;
		
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.DELETE)
	public void deleteQuestion(@RequestParam long questionId){
		
		questionRespository.delete(questionId);
	}
	
}
