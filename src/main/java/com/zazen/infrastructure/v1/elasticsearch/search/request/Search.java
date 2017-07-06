package com.zazen.infrastructure.v1.elasticsearch.search.request;

public class Search {
	Query query;
	
	public Search(Query query) {
		this.query = query;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
	
	
}
