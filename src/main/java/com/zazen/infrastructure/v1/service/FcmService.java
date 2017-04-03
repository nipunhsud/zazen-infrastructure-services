package com.zazen.infrastructure.v1.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.zazen.infrastructure.v1.pojos.Message;

public class FcmService {
	
	private static String FCM_URL = "https://fcm.googleapis.com/fcm/send";
	private static String SERVER_KEY = "key=AAAAmoa49IE:APA91bFWvyzF0pAaZoTaaE7Srvldui7z4PUoxdMZui_Qe38QY9vAQGdvMPmb43TlHItLZnUTz7FTZSqz9D5Hbm1B7-REufrqNLzwfsSgPGoHeoa3Hz856XB_3LQ9jHezVdWO29FiPPu5";
	
	
	public void sendFcmMessage(Message message) throws ClientProtocolException, IOException{
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(FCM_URL);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", SERVER_KEY);

		JSONObject messageToSend = new JSONObject();
		messageToSend.put("to", message.getTo());
		messageToSend.put("priority", message.getPriority());

		JSONObject notification = new JSONObject();
		notification.put("title", message.getNotification().getTitle());
		notification.put("body", message.getNotification().getBody());

		messageToSend.put("notification",  message.getNotification());

		post.setEntity(new StringEntity(messageToSend.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);
		System.out.println(response);
		System.out.println(messageToSend);
	}
}
