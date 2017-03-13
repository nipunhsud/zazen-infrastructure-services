package com.zazen.infrastructure.v1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.repository.QuestionRepository;
import com.zazen.infrastructure.v1.service.QuestionService;


@Controller
@RequestMapping("questions")
public class QuestionController {

	Logger logger= LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionRepository  questionRespository;
	
	@RequestMapping(value = "/question", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody 
	public Question postQuestion( @RequestBody Question question){
		logger.info(question.toString());
		Question ques = questionRespository.save(question);
		logger.debug("Saved");
		return ques;
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public Question getQuestionById( @RequestParam(value = "questionId") String questionId){
		Question question = questionRespository.findOne(questionId);
		System.out.println(question.toString());
		return question;
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
