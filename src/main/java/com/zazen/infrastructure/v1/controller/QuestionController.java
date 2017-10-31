package com.zazen.infrastructure.v1.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zazen.infrastructure.v1.pojos.Message;
import com.zazen.infrastructure.v1.pojos.Notification;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.QuestionRepository;
import com.zazen.infrastructure.v1.repository.UserRepository;
import com.zazen.infrastructure.v1.service.FcmService;
import com.zazen.infrastructure.v1.service.QuestionService;
import com.zazen.infrastructure.v1.service.SearchService;


@RestController
@RequestMapping("questions")
@CrossOrigin(origins = "*",maxAge = 3600)
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
	
	@Autowired
	private SearchService searchService;

	//	@Autowired
	//	private Client elasticClient;


	@RequestMapping(value = "/question", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody 
	public Question postQuestion( @RequestBody Question question){
		logger.info(question.toString());
		
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

		Question createdQuestion = questionRespository.save(question);
		//this would use search service to search and return users around the question
		//searchService.indexQuestion(createdQuestion);
		List<User> usersAroundLocation = searchService.searchUsersbyLocation(createdQuestion.getLatitude(), createdQuestion.getLongitude());
		//Send question to these users using fcm service
		if(usersAroundLocation != null){
			questionService.sendMessage(createdQuestion, usersAroundLocation);	
		}
		//this.sendMessage(question.getQuery());
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

	public void sendMessage(String query){
		Message message = new Message();
		//phone id - "fXaM6Dic1nI:APA91bE7-bxvj4JVgj4cBK9GG2QKr8fsYG6tVAWm9jskO7R6tzWSGHODOGLhj2YkMoIa0tHKQ1HqUn10zDhyqCaMckuuQWWO0bAtZDijUE0Q-RsU7GAhayNuAAU54IRmo1Z01Bi8gzwA"
		message.setTo("f1y5sPexfCA:APA91bHDmkciFE9aO76BSpANJ3gZ_phyEiKqoXWocPkBnAVWORV-hjEHWbY9uMR4Jn-nbYTyfDgndAQ2MPE46Z3TlKok1eKeUNCuzNcmvHIm-yvO5VfhFFy1scyZHK2pj-mglzNEgk33");
		//TODO think about how to prioritize 
		//message.setPriority(Priority.HIGH);
		Notification note = new Notification();
		note.setBody(query);
		note.setTitle("1234566");
		message.setNotification(note);
		try {
			fcmService.sendFcmMessage(message);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//message/
	}
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
