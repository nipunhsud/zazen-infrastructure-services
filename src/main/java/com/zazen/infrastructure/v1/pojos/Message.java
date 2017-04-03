package com.zazen.infrastructure.v1.pojos;

public class Message {
	
	private Notification notification;
	
	private String to;
	
	private String priority;

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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
}
