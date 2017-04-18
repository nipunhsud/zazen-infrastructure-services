package com.zazen.infrastructure.v1.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zazen.infrastructure.configuration.enumeration.Priority;
import com.zazen.infrastructure.v1.pojos.Message;
import com.zazen.infrastructure.v1.pojos.Notification;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.QuestionRepository;
import com.zazen.infrastructure.v1.repository.UserRepository;
import com.zazen.infrastructure.v1.service.FcmService;
import com.zazen.infrastructure.v1.service.QuestionService;
import com.zazen.infrastructure.v1.vo.QuestionRequestVO;


@RestController
@RequestMapping("questions")
public class QuestionController {

	Logger logger= LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionRepository  questionRespository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FcmService fcmService;
	

//	@Autowired
//	private Client elasticClient;
	
	
	@RequestMapping(value = "/question", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody 
	public Question postQuestion( @RequestBody QuestionRequestVO questionRequest){
		logger.info(questionRequest.toString());
		User user = userRepository.findOne(questionRequest.getUserId());
		Question question = questionRequest.mapToQuestion(questionRequest);
		question.setUser(user);
		logger.debug("Saved");
		
		//#TODO Notes for Elastic search
		// Create indexes for lat and long.
		// Need to do a geo location search and find the lat and long that around within a certain radius
		// Using that lat and long, find users and their registration id
		//Use fcm service to send question to the listed users.
		
		// Comment this part on your machine till i complete the testing.
//		IndexResponse indexResponse=elasticClient.prepareIndex("questions", "question").setSource(putJsonDocument(questionRequest.getQuery(),
//				questionRequest.getDeviceId(),questionRequest.getLocationLatitue(),
//				questionRequest.getLocationLongitute())).get();
//		
//		elasticClient.close();
		
		//#TODO use a cron job to run and get users around the location of the question asked
		// From those users find the registration Id and using fcm service send notifications to them 
		// Maybe need a status enum?
		
		//List<User> usersAroundLocation = questionService.getUsersAroundQuestion(question);
		//Send question to these users using fcm service
		Question createdQuestion = questionRespository.save(question);
		//questionService.sendMessage(createdQuestion, usersAroundLocation);
		return createdQuestion;
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public Question getQuestionById( @PathVariable("id") String questionId){
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
	public void deleteQuestion(@PathVariable("id") long questionId){
		
		questionRespository.delete(questionId);
	}
	
	@RequestMapping(value="/user/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestionsByUser(@PathVariable("id") String userId){
		List<Question> questionList = questionRespository.findAllByUser(userId);
		return questionList;		
	}
	
	@RequestMapping(value="/latitude/{lat}/longitude/{long}" , method = RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestionsByLocation(@PathVariable("lat") Long longitude,@PathVariable("long") Long latitude){
		List<Question> questions = questionRespository.findAllByLocation(longitude, latitude);
		return questions;		
	}
	
//	public void sendMessage(String query){
//		Message message = new Message();
//		//phone id - "fXaM6Dic1nI:APA91bE7-bxvj4JVgj4cBK9GG2QKr8fsYG6tVAWm9jskO7R6tzWSGHODOGLhj2YkMoIa0tHKQ1HqUn10zDhyqCaMckuuQWWO0bAtZDijUE0Q-RsU7GAhayNuAAU54IRmo1Z01Bi8gzwA"
//		message.setTo("e_4bc0aoIdg:APA91bH6aoxf_Rkte6B6Zd0hI9EpIH9_0DTyDrfl36vuLz1odo_-BqKwMfqcIBOemmRBqY6vyDjSWksUrmhY1L6Nmgc7t1cq0Bxa5ARIPWrb-UK0uAVyB0ncvktklzg0tg1Fb6CW9o-e");
//		//TODO think about how to prioritize 
//		//message.setPriority(Priority.HIGH);
//		Notification note = new Notification();
//		note.setBody(query);
//		note.setTitle("Test Me");
//		message.setNotification(note);
//		try {
//			fcmService.sendFcmMessage(message);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//message/
//	}
//	
	
	private static Map<String, Object> putJsonDocument(String question,String deviceId,long lat,long lon){
		Map<String, Object> jsonDocument = new HashMap<String, Object>();
		jsonDocument.put("question", question);
		jsonDocument.put("deviceId", deviceId);
		Map<String,Long> mapLocation=new HashMap<String,Long>();
		mapLocation.put("lat",lat);
		mapLocation.put("lon", lon);
		jsonDocument.put("location", mapLocation);
		return jsonDocument;
		}
	
}
