package com.zazen.infrastructure.v1.elasticsearch.search.request;

public class Query {
	private Bool bool;
	
	public Query(Bool bool){
		this.bool =  bool;
	}
	
	public Bool getBool() {
		return bool;
	}

	public void setBool(Bool bool) {
		this.bool = bool;
	}
	
	
}
