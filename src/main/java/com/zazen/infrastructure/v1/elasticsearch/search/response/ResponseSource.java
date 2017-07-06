package com.zazen.infrastructure.v1.elasticsearch.search.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseSource {
	private int took;
	@JsonProperty("timed_out")
	private boolean timedOut;
	@JsonProperty("_shards")
	private Shard shard;
	private Hit hits;
	public int getTook() {
		return took;
	}
	public void setTook(int took) {
		this.took = took;
	}
	public boolean isTimedOut() {
		return timedOut;
	}
	public void setTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
	}
	public Shard getShard() {
		return shard;
	}
	public void setShard(Shard shard) {
		this.shard = shard;
	}
	public Hit getHits() {
		return hits;
	}
	public void setHits(Hit hits) {
		this.hits = hits;
	}
	
}
