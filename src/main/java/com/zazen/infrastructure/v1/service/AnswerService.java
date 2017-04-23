package com.zazen.infrastructure.v1.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zazen.infrastructure.configuration.enumeration.Priority;
import com.zazen.infrastructure.v1.pojos.Answer;
import com.zazen.infrastructure.v1.pojos.Message;
import com.zazen.infrastructure.v1.pojos.Notification;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.AnswerRepository;

@Service("answerService")
public class AnswerService {
	
	@Autowired
	private FcmService fcmService;
	
	public void addAnswer(Answer answer){
		//answerRepository.save(answer);
	}
	
public void sendMessage(Answer answer, User user){
		
			Message message = new Message();
			//phone id - "fXaM6Dic1nI:APA91bE7-bxvj4JVgj4cBK9GG2QKr8fsYG6tVAWm9jskO7R6tzWSGHODOGLhj2YkMoIa0tHKQ1HqUn10zDhyqCaMckuuQWWO0bAtZDijUE0Q-RsU7GAhayNuAAU54IRmo1Z01Bi8gzwA"
			//message.setTo("e_4bc0aoIdg:APA91bH6aoxf_Rkte6B6Zd0hI9EpIH9_0DTyDrfl36vuLz1odo_-BqKwMfqcIBOemmRBqY6vyDjSWksUrmhY1L6Nmgc7t1cq0Bxa5ARIPWrb-UK0uAVyB0ncvktklzg0tg1Fb6CW9o-e");
			message.setTo(user.getRegistrationId());
			//TODO think about how to prioritize , everything is high for now
			message.setPriority(Priority.HIGH);
			Notification note = new Notification();
			note.setBody(answer.getAnswerRecommendation());
			note.setTitle(answer.getQuestion().getLocationName());
			message.setNotification(note);
			
			JSONObject messageData = new JSONObject();
			messageData.put("type", "answer");
			message.setData(messageData);
			
			try {
				String response = fcmService.sendFcmMessage(message);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
