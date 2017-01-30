package com.zazen.infrastructure.v1.pojos;

import java.util.Date;

public class Recommendation {
	
	private long id;
	
	private String description;
	
	private int upvoteCounter;
	
	private Date createdDate;
	
	private Date lastModfiedDate;
	
	private int views;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUpvoteCounter() {
		return upvoteCounter;
	}

	public void setUpvoteCounter(int upvoteCounter) {
		this.upvoteCounter = upvoteCounter;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModfiedDate() {
		return lastModfiedDate;
	}

	public void setLastModfiedDate(Date lastModfiedDate) {
		this.lastModfiedDate = lastModfiedDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
}
