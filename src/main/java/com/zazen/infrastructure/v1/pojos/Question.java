package com.zazen.infrastructure.v1.pojos;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zazen.infrastructure.v1.repository.TimeStampedEntity;

@Component
@Entity
public class Question extends TimeStampedEntity {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	private String query;
	
	private String locationName;
	
	//TODO Eventually move this into Location table?
	//@Column(precision=15, scale=13)
	private String latitude;
	
	//@Column(precision=15, scale=13)
	private String longitude;
	
	private String userId;
	
	public Question(){}
	
	public Question(String query, String locationName, String latitude, String longitude, Date createdDate, Date lastModified){//, , Date lastModified){
		
		this.query = query;
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
