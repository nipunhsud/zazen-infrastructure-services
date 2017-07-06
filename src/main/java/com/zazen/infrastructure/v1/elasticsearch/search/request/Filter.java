package com.zazen.infrastructure.v1.elasticsearch.search.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filter {
	@JsonProperty("geo_distance")
	private GeoDistance geoDistance;
	
	public Filter(GeoDistance geoDistance){
		this.geoDistance =  geoDistance;
	}
	
	public GeoDistance getGeoDistance() {
		return geoDistance;
	}

	public void setGeoDistance(GeoDistance geoDistance) {
		this.geoDistance = geoDistance;
	}
	
	
}
