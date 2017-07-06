package com.zazen.infrastructure.v1.elasticsearch.search.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResponse {
	@JsonProperty("Source")
	private ResponseSource source;

	public ResponseSource getSource() {
		return source;
	}

	public void setSource(ResponseSource source) {
		this.source = source;
	}
	
}
