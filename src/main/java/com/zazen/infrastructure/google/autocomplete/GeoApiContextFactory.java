package com.zazen.infrastructure.google.autocomplete;

import org.springframework.stereotype.Component;

import com.google.maps.GeoApiContext;

@Component
public class GeoApiContextFactory {
	
	public GeoApiContext getInstance(){
		GeoApiContext context = new GeoApiContext.Builder()
	    .apiKey("AIzaSyDwylHJvJ_ha6Urhp35e-Ue80usiCKCxfE")
	    .build();
		return context;
	}
	
}
