package com.zazen.infrastructure.v1.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Question {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	private String query;
	
	private String locationName;
	
	private Long latitude;
	
	private Long longitude;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
	private Date createdDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
	private Date lastModified;
//	
//	@ManyToOne
//	@JoinColumn(nullable = false)
//	@JsonIgnore
//	private User user;
//	
	protected Question(){}
	
	public Question(String query, String locationName, Long latitude, Long longitude, Date createdDate, Date lastModified){//, , Date lastModified){
		
		this.query = query;
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
		
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
	
	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public  void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

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

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
