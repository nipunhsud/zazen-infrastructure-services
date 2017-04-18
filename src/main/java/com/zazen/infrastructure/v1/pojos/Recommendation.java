package com.zazen.infrastructure.v1.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Recommendation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String description;
	
	private int upvoteCounter;
	
	private Date createdDate;
	
	private Date lastModfiedDate;
	
	private int views;
	
	private Recommendation(){}
	
	private Recommendation(String description, int upvoteCounter, Date createdDate, Date lastModifiedDate, int views) {
		
		this.description = description;
		this.upvoteCounter = upvoteCounter;
		this.createdDate = createdDate;
		this.lastModfiedDate = lastModifiedDate;
		this.views = views;
		
	}
	
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
