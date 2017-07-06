package com.zazen.infrastructure.v1.search;

import org.elasticsearch.common.geo.GeoPoint;

public class MappingProperties {
	
	public LocationName locationName;
	public GeoPoint geoPoint;
	public LastUpdated lastUpdated;
	
	public LocationName getLocationName() {
		return locationName;
	}
	public void setLocationName(LocationName locationName) {
		this.locationName = locationName;
	}
	public GeoPoint getGeoPoint() {
		return geoPoint;
	}
	public void setGeoPoint(GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}
	public LastUpdated getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LastUpdated lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
}
