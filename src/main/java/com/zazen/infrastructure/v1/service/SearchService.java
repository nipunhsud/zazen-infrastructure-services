package com.zazen.infrastructure.v1.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zazen.infrastructure.v1.elasticsearch.search.request.Bool;
import com.zazen.infrastructure.v1.elasticsearch.search.request.Filter;
import com.zazen.infrastructure.v1.elasticsearch.search.request.GeoDistance;
import com.zazen.infrastructure.v1.elasticsearch.search.request.GeoPoint;
import com.zazen.infrastructure.v1.elasticsearch.search.request.Query;
import com.zazen.infrastructure.v1.elasticsearch.search.request.Search;
import com.zazen.infrastructure.v1.elasticsearch.search.response.Hits;
import com.zazen.infrastructure.v1.elasticsearch.search.response.ResponseSource;
import com.zazen.infrastructure.v1.pojos.Location;
import com.zazen.infrastructure.v1.pojos.Question;
import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.UserRepository;

@Service
public class SearchService {

	Logger logger = LoggerFactory.getLogger(SearchService.class);
	
	@Autowired
	UserRepository userRepository;

	RestClient restClient = null;

	SearchService() {
		createRestClient();
	}

	// PUT locations/location/2
	// {
	// "query": "What is the time?"
	// "locationName":"Friendly Toast",
	// "geoPoint":
	// {
	//
	// "lat": 42.3484,
	// "lon": 71.0733
	//
	// },
	// "lastUpdate":1402144560000
	// }
	public void indexQuestion(Question question) {

		// This would change, I will need to index all users ids and their
		// location when a user signs up and every subsequent location change
		String jsonString = new JSONObject()
		.put("query", question.getQuery())
		.put("locationName", question.getLocationName())
		.put("userId", question.getUserId())
		.put("geoPoint",
				new JSONObject().put("lat", question.getLatitude())
				.put("lon", question.getLongitude()))
				.toString();

		HttpEntity entity = new NStringEntity(jsonString,
				ContentType.APPLICATION_JSON);
		String endpoint = "/questions/question/" + question.getId();
		logger.info("Endpoint to query " + endpoint);
		try {
			Response indexResponse = restClient.performRequest("PUT", endpoint,
					Collections.<String, String> emptyMap(), entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void indexUserLocation(Location location) {

		String jsonString = new JSONObject()
		.put("userId", location.getUserId())
		.put("geoPoint",
				new JSONObject().put("lat", location.getLatitude())
				.put("lon", location.getLongitude()))
				.toString();

		HttpEntity entity = new NStringEntity(jsonString,
				ContentType.APPLICATION_JSON);
		String userLocationEndpoint = "/users/location/" + location.getId();
		logger.info("Endpoint to query " + userLocationEndpoint);
		try {
			Response indexResponse = restClient.performRequest("PUT",
					userLocationEndpoint,
					Collections.<String, String> emptyMap(), entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// GET /users/location/_search
	// {
	// "query": {
	// "bool": {
	// "filter": {
	// "geo_distance": {
	// "distance": "1km",
	// "geoPoint" : {
	// "lat" : 21.9,
	// "lon" : 29
	// }
	// }
	// }
	// }
	// }
	// }
	public List<User> searchUsersbyLocation(String latitude, String longitude) {
		// String jsonString = new JSONObject()
		// .put("query", location.getUserId())
		// .put("geoPoint", new JSONObject()
		// .put("lat", location.getLatitude())
		// .put("lon", location.getLongitude())
		// ).toString();
		List<User> userIdList = null;
		ObjectMapper mapper = new ObjectMapper();
		String searchDistance = "1km";
		GeoPoint geoPoint = new GeoPoint(latitude, longitude);
		GeoDistance geoDistance = new GeoDistance(geoPoint, searchDistance);
		Filter filter = new Filter(geoDistance);
		Bool bool = new Bool(filter);
		Query query = new Query(bool);
		Search search = new Search(query);
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(search);
			HttpEntity entity = new NStringEntity(jsonString,
					ContentType.APPLICATION_JSON);
			String userByLocationSearchEndpoint = "/users/location/_search";
			Response indexResponse = restClient.performRequest("GET",
					userByLocationSearchEndpoint,
					Collections.<String, String> emptyMap(), entity);
			HttpEntity entityw = indexResponse.getEntity();
			String responseString = EntityUtils.toString(entityw, "UTF-8");
			System.out.println(responseString);
			ResponseSource response = mapper.readValue(responseString, ResponseSource.class);
			List<Hits> hitsList = response.getHits().getHits();
			userIdList = new ArrayList<User>();
			for(Hits hits: hitsList){
				User user = userRepository.findOne(hits.getSource().getUserId());
				userIdList.add(user);
			}
			logger.debug("response "+ response);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userIdList;
	}

	public void closeRestClient() {
		try {
			restClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RestClient createRestClient() {
		restClient = RestClient.builder(
				new HttpHost("localhost", 9200, "http"),
				new HttpHost("localhost", 9201, "http")).build();
		return restClient;
	}

}
