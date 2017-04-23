package com.zazen.infrastructure.v1.pojos;

import java.util.Properties;

import org.json.JSONObject;

import com.zazen.infrastructure.configuration.enumeration.Priority;

public class Message {
	
	private Notification notification;
	
	private String to;
	
	private Priority priority;
	
	private JSONObject data;

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
	
	
}
