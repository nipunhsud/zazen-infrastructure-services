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
	@Column(precision=10, scale=6)
	private BigDecimal latitude;
	
	@Column(precision=10, scale=6)
	private BigDecimal longitude;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
//	private Date createdDate;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
//	private Date lastModified;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnore
	private User user;
	
	public Question(){}
	
	public Question(String query, String locationName, BigDecimal latitude, BigDecimal longitude, Date createdDate, Date lastModified){//, , Date lastModified){
		
		this.query = query;
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
//		this.createdDate = createdDate;
//		this.lastModified = lastModified;
		
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
	
	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public  void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//	

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

//	public Date getLastModified() {
//		return lastModified;
//	}
//
//	public void setLastModified(Date lastModified) {
//		this.lastModified = lastModified;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
