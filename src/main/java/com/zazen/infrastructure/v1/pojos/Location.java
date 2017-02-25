package com.zazen.infrastructure.v1.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long userId;
	
	private long latitude;
	
	private long longitutde;
	
	private Location(){}
	
	private Location(long userId, long latitude, long longitude){
		this.userId = userId;
		this.latitude = latitude;
		this.longitutde = longitude;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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
