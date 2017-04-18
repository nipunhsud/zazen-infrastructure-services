package com.zazen.infrastructure.v1.pojos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseTimedEntity {
		
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
	private Date createdDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
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
