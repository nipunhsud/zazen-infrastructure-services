package com.zazen.infrastructure.v1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.zazen.infrastructure.v1.pojos.Message;

@Component
public class FcmService {
	
	private static String FCM_URL = "https://fcm.googleapis.com/fcm/send";
	private static String SERVER_KEY = "key=AAAALFsjD1Q:APA91bHONY85PMG3TmP9E754P6n-7jGvVoFQonKpAgrJiS5S_QcNeGBI7-FPRgIVR_uic3R5-XXmKiyuVm2Qd_5uDSQMdWRMFenxESerDHGPH1cWMD174OFrnPAa5qXTMIoSX0OPIABc";
	
	
	public String sendFcmMessage(Message message) throws ClientProtocolException, IOException{
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(FCM_URL);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", SERVER_KEY);

		JSONObject messageToSend = new JSONObject();
		JSONArray registerationIds = new JSONArray();
		registerationIds.put(message.getTo());
		JSONObject notification = new JSONObject();
		notification.put("title", message.getNotification().getTitle());
		notification.put("body", message.getNotification().getBody());

		messageToSend.put("notification",  notification);
		messageToSend.put("registration_ids", registerationIds);
		messageToSend.put("priority", message.getPriority());
		//messageToSend.put("content-available","1");

		

		post.setEntity(new StringEntity(messageToSend.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);
		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));
		
		int status = response.getStatusLine().getStatusCode();
		if(status == 200){
			//happy path
		}

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println("Here is the response"+ result.toString());
		System.out.println(messageToSend);
		return result.toString();
	}
}
