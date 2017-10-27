package com.zazen.infrastructure.google.autocomplete;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;

@Component
public class PlacesAutocompleteServices {

	@Autowired
	GeoApiContextFactory geoApiContextFactory;

	public AutocompletePrediction[] getPlacesResult(String searchString, String latitude, String longitude) throws ApiException,
			InterruptedException, IOException, ParseException {
		DecimalFormat decimalFormat = new DecimalFormat("#");
		LatLng location = new LatLng(decimalFormat.parse(latitude).longValue(), decimalFormat.parse(longitude).longValue());
		AutocompletePrediction[] placesSearchResponse = PlacesApi
				.placeAutocomplete(geoApiContextFactory.getContext(),
						searchString)
						.location(location)
						.radius(1000)
						.language("en")
				.await();
		
		return placesSearchResponse;
	}

}
