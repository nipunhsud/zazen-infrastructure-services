package com.zazen.infrastructure.v1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;
import com.zazen.infrastructure.google.autocomplete.PlacesAutocompleteServices;

@Controller
public class PlacesController {
	
	@Autowired
	PlacesAutocompleteServices placesAutocompleteServices;
	
	@RequestMapping(value="/place" , method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<AutocompletePrediction> getGooglePlaces(@RequestParam(value = "search") String searchTerm, @RequestParam(value = "latitude") String latitude, @RequestParam(value = "longitude") String longitude) throws ApiException, InterruptedException, IOException, ParseException{
		return Arrays.asList(placesAutocompleteServices.getPlacesResult(searchTerm, latitude, longitude));
	}
}
