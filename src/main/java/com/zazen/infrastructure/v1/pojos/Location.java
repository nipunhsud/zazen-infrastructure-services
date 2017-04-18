package com.zazen.infrastructure.v1.pojos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	private String userId;
	
	@Column(precision=10, scale=6)
	private BigDecimal latitude;
	
	@Column(precision=10, scale=6)
	private BigDecimal longitutde;
	
	private Location(){}
	
	private Location(String userId, BigDecimal latitude, BigDecimal longitude){
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

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitutde() {
		return longitutde;
	}

	public void setLongitutde(BigDecimal longitutde) {
		this.longitutde = longitutde;
	}
}
