package com.zazen.infrastructure.v1.elasticsearch.search.response;

import com.zazen.infrastructure.v1.elasticsearch.search.request.GeoPoint;

public class Source {
	private String locationName;
    private String query;
    private String userId;
    private GeoPoint geoPoint;
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public GeoPoint getGeoPoint() {
		return geoPoint;
	}
	public void setGeoPoint(GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}
    
    
}
