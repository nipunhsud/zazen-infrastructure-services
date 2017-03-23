package com.zazen.infrastructure.v1.repository;

import java.util.Date;

public class TimeStampedEntity {
	
	private Date createTime;
	
	private Date lastModified;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
