package com.zazen.infrastructure.v1.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String query;
	
	private long latitude;
	
	private long longitude;
	
	private Date createdDate;
	
	private Date lastModified;
	
	private Question(){}
	
	public Question(String query, long latitude, long longitude, Date createdDate, Date lastModified){
		
		this.query = query;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
		
	}
	
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
		return latitude;
	}

	public void setLadititude(long latitude) {
		this.latitude = latitude;
	}

	public long getLogitude() {
		return latitude;
	}

	public void setLogitude(long longitude) {
		this.longitude = longitude;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public  void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
