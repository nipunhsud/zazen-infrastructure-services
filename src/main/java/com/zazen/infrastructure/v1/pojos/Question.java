package com.zazen.infrastructure.v1.pojos;

import java.util.Date;

public class Question {
	
	private long id;
	
	private String query;
	
	private long ladititude;
	
	private long logitude;
	
	private Date createdDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public long getLadititude() {
		return ladititude;
	}

	public void setLadititude(long ladititude) {
		this.ladititude = ladititude;
	}

	public long getLogitude() {
		return logitude;
	}

	public void setLogitude(long logitude) {
		this.logitude = logitude;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public  void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
