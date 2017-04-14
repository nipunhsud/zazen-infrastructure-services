package com.zazen.infrastructure.v1.service;


import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.zazen.infrastructure.configuration.enumeration.Priority;
import com.zazen.infrastructure.v1.pojos.Message;
import com.zazen.infrastructure.v1.pojos.Notification;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.vo.QuestionRequestVO;



@Service
public class QuestionService {

	Logger log= LoggerFactory.getLogger(QuestionService.class);


	@Autowired
	private FcmService fcmService;
	
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
	
	public void sendMessage(Question question){
		Message message = new Message();
		//phone id - "fXaM6Dic1nI:APA91bE7-bxvj4JVgj4cBK9GG2QKr8fsYG6tVAWm9jskO7R6tzWSGHODOGLhj2YkMoIa0tHKQ1HqUn10zDhyqCaMckuuQWWO0bAtZDijUE0Q-RsU7GAhayNuAAU54IRmo1Z01Bi8gzwA"
		//message.setTo("e_4bc0aoIdg:APA91bH6aoxf_Rkte6B6Zd0hI9EpIH9_0DTyDrfl36vuLz1odo_-BqKwMfqcIBOemmRBqY6vyDjSWksUrmhY1L6Nmgc7t1cq0Bxa5ARIPWrb-UK0uAVyB0ncvktklzg0tg1Fb6CW9o-e");
		message.setTo(question.getUser().getRegistrationId());
		//TODO think about how to prioritize , everything is high for now
		message.setPriority(Priority.HIGH);
		Notification note = new Notification();
		note.setBody(question.getQuery());
		note.setTitle(question.getLocationName() + " Review Update");
		message.setNotification(note);
		try {
			String response = fcmService.sendFcmMessage(message);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//message/
	}
	
}

