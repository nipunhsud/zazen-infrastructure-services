package com.zazen.infrastructure.v1.repository;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TimeStampedEntity {
	
	private Date createTime;
	
	private Date lastModified;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime() {
		if(this.createTime == null){
			this.createTime = new Date();
		}
		
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified() {
		this.lastModified = new Date();
	}
	
	
}
