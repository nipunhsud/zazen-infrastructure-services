package com.zazen.infrastructure.v1.pojos;

import java.util.Properties;

import com.zazen.infrastructure.configuration.enumeration.Priority;

public class Message {
	
	private Notification notification;
	
	private String to;
	
	private Priority priority;

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
	
	
}
