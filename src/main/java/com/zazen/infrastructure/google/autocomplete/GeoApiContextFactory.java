package com.zazen.infrastructure.google.autocomplete;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.maps.GeoApiContext;

@Component
public class GeoApiContextFactory {
	
	private GeoApiContext context;
	
	@PostConstruct
	public void initialize(){
		context = new GeoApiContext.Builder()
	    .apiKey("AIzaSyDwylHJvJ_ha6Urhp35e-Ue80usiCKCxfE")
	    .build();
	}
	
	public GeoApiContext getContext(){
		return this.context;
	}
}
