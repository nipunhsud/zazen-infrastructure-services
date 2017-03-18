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
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.QuestionRepository;
import com.zazen.infrastructure.v1.repository.UserRepository;
import com.zazen.infrastructure.v1.service.QuestionService;
import com.zazen.infrastructure.v1.vo.QuestionRequestVO;


@Controller
@RequestMapping("questions")
public class QuestionController {

	Logger logger= LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionRepository  questionRespository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/question", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody 
	public Question postQuestion( @RequestBody QuestionRequestVO questionRequest){
		logger.info(questionRequest.toString());
		User user = userRepository.findOne(questionRequest.getUserId());
		Question question = questionRequest.mapToQuestion(questionRequest);
		question.setUser(user);
		logger.debug("Saved");
		return questionRespository.save(question);
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
	
	@RequestMapping(value="/user/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestionsByUser(@RequestParam String userId){
		List<Question> questionList = questionRespository.findAllByUser(userId);
		return questionList;		
	}
	
	@RequestMapping(value="/latitude/{id}/longitude/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestionsByLocation(Long longitude, Long latitude){
		List<Question> questions = questionRespository.findAllByLocation(longitude, latitude);
		return questions;		
	}
	
}
