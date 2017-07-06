package com.zazen.infrastructure.v1.elasticsearch.search.request;

public class GeoDistance {
	private String distance;
	private GeoPoint geoPoint;
	
	public GeoDistance(GeoPoint geoPoint, String distance ){
		this.geoPoint = geoPoint;
		this.distance = distance;
	}
	
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public GeoPoint getGeoPoint() {
		return geoPoint;
	}
	public void setGeoPoint(GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}
	
	
	
}
