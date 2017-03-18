package com.zazen.infrastructure.v1.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Location {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	private String userId;
	
	private long latitude;
	
	private long longitutde;
	
	private Location(){}
	
	private Location(String userId, long latitude, long longitude){
		this.userId = userId;
		this.latitude = latitude;
		this.longitutde = longitude;
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

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitutde() {
		return longitutde;
	}

	public void setLongitutde(long longitutde) {
		this.longitutde = longitutde;
	}
}
