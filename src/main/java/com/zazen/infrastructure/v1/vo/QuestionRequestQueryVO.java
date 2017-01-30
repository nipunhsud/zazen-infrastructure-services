package com.zazen.infrastructure.v1.vo;

public class QuestionRequestQueryVO {

	private String query;
	
	private long latitude;
	
	private long longitude;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
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
	
	
}
