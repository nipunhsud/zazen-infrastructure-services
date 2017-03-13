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

import com.fasterxml.jackson.databind.JsonNode;
import com.zazen.infrastructure.v1.pojos.Answer;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.repository.AnswerRepository;
import com.zazen.infrastructure.v1.repository.QuestionRepository;
import com.zazen.infrastructure.v1.service.AnswerService;
import com.zazen.infrastructure.v1.vo.AnswerRequestVO;

@Controller
public class AnswerController {
	
Logger log= LoggerFactory.getLogger(AnswerController.class);
	
	@Autowired
	private AnswerRepository  answerRespository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private Answer answer;
	
	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public Answer answerPost( @RequestBody AnswerRequestVO answerRequest) throws Exception{
		
		Question question = questionRepository.findOne(answerRequest.getQuestion());
		answer.setQuestion(question);
		answer.setAnswerRecommendation(answerRequest.getAnswer());
		Answer savedAnswer = answerRespository.save(answer);
		return savedAnswer;
	}
	
	@RequestMapping(value="/answers/{id}" , method = RequestMethod.GET)
	public Answer getQuestionById( @PathVariable("answerId") String answerId){
		return answerRespository.findOne(answerId);
	}
	
	@RequestMapping(value="/answers" , method = RequestMethod.GET)
	public List<Answer> getAllAnswers(){
		
		List<Answer> allAnswers = answerRespository.findAll();
		return allAnswers;
		
	}
	
	@RequestMapping(value="/answers/{id}" , method = RequestMethod.DELETE)
	public void deleteQuestion(@RequestParam long answerId){
		
		answerRespository.delete(answerId);
	}
	
	public void answerRequestConverToAnswer(AnswerRequestVO answerRequest){
		//answerRequest.copyTo(answer);
	}
}
