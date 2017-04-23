package com.zazen.infrastructure.v1.pojos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.zazen.infrastructure.v1.repository.TimeStampedEntity;

@Entity
@Component
public class Location extends TimeStampedEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	//@OneToOne
	private String userId;
	
	//@Column(precision=15, scale=13)
	private String latitude;
	
	//@Column(precision=15, scale=13)
	private String longitude;
	
	private Location(){}
	
	private Location(String userId, String latitude, String longitude){
		this.userId = userId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
