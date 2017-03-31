package com.zazen.infrastructure.v1.repository;

import java.util.Date;

public class BaseTimedEntity {
	
	private Date createdDate;
	
	private Date lastModified;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate() {
		if(this.createdDate == null){
			this.createdDate = new Date();	
		}
		
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified() {
		this.lastModified = new Date();
	}
	
	
}
