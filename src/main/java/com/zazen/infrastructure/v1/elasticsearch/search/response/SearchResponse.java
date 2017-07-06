package com.zazen.infrastructure.v1.elasticsearch.search.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResponse {
	private int took;
	@JsonProperty("timed_out")
	private boolean timedOut;
	@JsonProperty("_shards")
	private Shard shard;
	private Hit hits;
	
}
