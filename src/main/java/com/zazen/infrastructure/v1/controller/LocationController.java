package com.zazen.infrastructure.v1.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResponse;
import com.zazen.infrastructure.google.autocomplete.PlacesAutocompleteServices;
import com.zazen.infrastructure.v1.pojos.Location;
import com.zazen.infrastructure.v1.repository.LocationRepository;
import com.zazen.infrastructure.v1.repository.UserRepository;
import com.zazen.infrastructure.v1.service.SearchService;

@Controller
@RequestMapping("locations")
public class LocationController {
Logger logger= LoggerFactory.getLogger(LocationController.class);
	
	@Autowired
	private LocationRepository  locationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SearchService searchService;
	
	
	@RequestMapping(value = "/location", method = RequestMethod.PUT, headers = "Accept=application/json")
	@ResponseBody 
	public Location postLocation( @RequestBody Location location){
		Location existingLocation = locationRepository.findByUserId(location.getUserId());
		if(existingLocation == null){
			existingLocation = locationRepository.save(location);
		}else{
			existingLocation.setLatitude(location.getLatitude());
			existingLocation.setLongitude(location.getLongitude());
			locationRepository.update(existingLocation);
		}
		searchService.indexUserLocation(existingLocation);
		return existingLocation;
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	@ResponseBody
	public Location getLocationById( @RequestParam(value = "locationId") String locationId){
		Location location = locationRepository.findOne(locationId);
		return location;
	}
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public List<Location> getLlocations(){
		
		List<Location> allLocations = (List<Location>) locationRepository.findAll();
		return allLocations;
		
	}
	
	
	
	
}
