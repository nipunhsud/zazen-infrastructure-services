package com.zazen.infrastructure.v1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zazen.infrastructure.v1.pojos.Answer;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.pojos.Recommendation;
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.AnswerRepository;
import com.zazen.infrastructure.v1.repository.QuestionRepository;
import com.zazen.infrastructure.v1.repository.UserRepository;
import com.zazen.infrastructure.v1.service.AnswerService;
import com.zazen.infrastructure.v1.service.QuestionService;
import com.zazen.infrastructure.v1.vo.AnswerRequestVO;

@Controller
@RequestMapping("answers")
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
	
	@Autowired
	private Recommendation recommendation;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/answer", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody 
	public Answer answerPost( @RequestBody AnswerRequestVO answerRequest) throws Exception{
		
		Question question = questionRepository.findOne(answerRequest.getQuestionId());
		User user = userRepository.findOne(answerRequest.getUserId());
		
		answer.setQuestion(question);
		answer.setAnswerRecommendation(answerRequest.getAnswer());
		answer.setUser(user);
		recommendation.setDescription(answerRequest.getAnswer());
		answer.setRecommendation(recommendation);
		Answer savedAnswer = answerRespository.save(answer);
		
		//Send notification to user associated to the question.
		answerService.sendMessage(savedAnswer, question.getUser());
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
	
	@RequestMapping(value="/question/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Answer> listAnswersByQuestion(@RequestParam String questionId){
		List<Answer> answers = answerRespository.findAllByQuestion(questionId);
		return answers;		
	}
}
