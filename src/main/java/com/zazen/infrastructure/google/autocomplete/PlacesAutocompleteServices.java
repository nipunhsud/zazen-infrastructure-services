package com.zazen.infrastructure.google.autocomplete;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResponse;

@Component
public class PlacesAutocompleteServices {

	@Autowired
	GeoApiContextFactory geoApiContextFactory;

	public PlacesSearchResponse getPlacesResult(String searchString) throws ApiException,
			InterruptedException, IOException {

		PlacesSearchResponse placesSearchResponse = PlacesApi
				.textSearchQuery(geoApiContextFactory.getInstance(),
						searchString).radius(5000).language("en")
				.await();
		
		return placesSearchResponse;
	}

}
