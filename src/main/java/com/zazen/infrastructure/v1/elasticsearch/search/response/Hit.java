package com.zazen.infrastructure.v1.elasticsearch.search.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hit {
	private int total;
	@JsonProperty("max_score")
	private int maxScore;
	private List<Hits> hits;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public List<Hits> getHits() {
		return hits;
	}
	public void setHits(List<Hits> hits) {
		this.hits = hits;
	}
	
	
}
