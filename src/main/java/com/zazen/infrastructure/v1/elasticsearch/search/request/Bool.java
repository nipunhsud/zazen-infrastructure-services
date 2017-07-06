package com.zazen.infrastructure.v1.elasticsearch.search.request;

public class Bool {
	private Filter filter;
	
	public Bool(Filter filter){
		this.filter = filter;
	}
	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	
}
