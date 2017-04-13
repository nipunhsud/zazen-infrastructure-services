package com.zazen.infrastructure.configuration.enumeration;

public enum Priority {
	UNKOWN(0, "Unkown"),
	LOW(1, "Low"),
	MEDIUM(2, "Medium"),
	HIGH(3, "High");
	
	private Priority(int value, String name){
		this.value = value;
		this.name = name;
	}
	
	private int value;
	private String name;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
